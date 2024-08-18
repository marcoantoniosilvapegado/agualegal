package br.gov.go.sefaz.agualegal.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.domain.PreAnaliseResultado;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.exception.ParametrosNaoConfiguradosException;
import br.gov.go.sefaz.agualegal.exception.PreAnaliseException;
import br.gov.go.sefaz.agualegal.modelo.Grafica;
import br.gov.go.sefaz.agualegal.modelo.IeExcecao;
import br.gov.go.sefaz.agualegal.modelo.ParPreAnalise;
import br.gov.go.sefaz.agualegal.repository.ConsultaBaseSefazRepository;
import br.gov.go.sefaz.agualegal.repository.GraficaRepository;
import br.gov.go.sefaz.agualegal.repository.IeExcecaoRepository;
import br.gov.go.sefaz.agualegal.repository.ParPreAnaliseRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class PreAnaliseService {

	private GraficaRepository graficaRepository;
	private IeExcecaoRepository ieExcecaoRepository;
	private ParPreAnaliseRepository parPreAnaliseRepository;
	private ConsultaBaseSefazRepository consultaBaseSefazRepository;
	private ValidaTokenGraficaService validaTokenGraficaService;

	public PreAnaliseService(GraficaRepository graficaRepository, 
			IeExcecaoRepository ieExcecaoRepository,
			ParPreAnaliseRepository parPreAnaliseRepository,
			ConsultaBaseSefazRepository consultaBaseSefazRepository,
			ValidaTokenGraficaService validaTokenGraficaService) {
		this.graficaRepository = graficaRepository;
		this.ieExcecaoRepository = ieExcecaoRepository;
		this.parPreAnaliseRepository = parPreAnaliseRepository;
		this.consultaBaseSefazRepository = consultaBaseSefazRepository;
		this.validaTokenGraficaService = validaTokenGraficaService;
	}

	public PreAnaliseResultado preAnaliseEnvasadora(DadosSolicitacaoDTO dto) throws PreAnaliseException {
		Long situacaoIESefaz = null;
		
		if(!UtilsAguaLegal.isEmpty(dto.getCadastro().getInscricaoEstadual())) {
			/*Havendo IE, em exceção ou não, será feita uma busca da situação fiscal atual dessa IE
			 * na base da sefaz, para persistencia no banco local do sistema agua legal*/			
			
			situacaoIESefaz = 
					this.consultaBaseSefazRepository.retornaSituacaoFiscal2(dto.getCadastro().getInscricaoEstadual());
			
			if(situacaoIESefaz == null) {
				situacaoIESefaz = 9L;
			}
		}

		/* Valida inicialmente se existe a gráfica na base */
		Optional<Grafica> buscaCpfCnpjGrafica = this.graficaRepository.findByCnpj(dto.getCnpjGrafica());
		if (buscaCpfCnpjGrafica.isEmpty()) {
			return new PreAnaliseResultado(false, 7, situacaoIESefaz);
		}
		
		/*Verifica se token enviado é válido*/
		Boolean tokenValido = 
				this.validaTokenGraficaService.validaTokenGrafica(dto.getCnpjGrafica(), dto.getTokenGrafica());
		if(!tokenValido) {
			return new PreAnaliseResultado(false, 8, situacaoIESefaz);
		}
	
		/* Verificar se é válido o CNPJ da envasadora */
		if (UtilsAguaLegal.isEmpty(dto.getCadastro().getCnpj())
				|| !UtilsAguaLegal.verificaCnpjValido(dto.getCadastro().getCnpj())) {
			return new PreAnaliseResultado(false, 9, situacaoIESefaz);
		}

		/*
		 * Se a inscrição vier vazia, pela regra será considerado envasadora de fora do
		 * estado. Assim sendo, não será sujeita às validações do método
		 * validacaoContribuinteInterno
		 */
		if (!UtilsAguaLegal.isEmpty(dto.getCadastro().getInscricaoEstadual())) {
						
			/* Verifica se o IE consta na tabela de exceção */
			Optional<IeExcecao> ieExcecao = this.ieExcecaoRepository
					.findIEExcecaoAtivo(dto.getCadastro().getInscricaoEstadual());
			if (ieExcecao.isEmpty()) {
				/*
				 * Caso não esteja, passará pelas validações de cnae e situação fiscal, caso as
				 * mesmas estejam paremetrizadas
				 */
				ParPreAnalise parametros = null;

				Optional<ParPreAnalise> parOptional = this.parPreAnaliseRepository.findById(1);
				if (parOptional.isEmpty()) {
					throw new ParametrosNaoConfiguradosException(
							"Os parâmetros gerais de pré análise não estão configurados!");
				} else {
					parametros = parOptional.get();
				}

				if (parametros.getExisteSolicitante().equals("S")) {					
					if (!consultaBaseSefazRepository.verificaEnvasadoraExiste(dto.getCadastro().getInscricaoEstadual())) {
						return new PreAnaliseResultado(false, 10,situacaoIESefaz);
					}

				}
				if (parametros.getSituacaoFiscAtiva().equals("S")) {					
					if (!consultaBaseSefazRepository.verificaSituacaoFiscalAtiva(dto.getCadastro().getInscricaoEstadual())) {
						return new PreAnaliseResultado(false, 11,situacaoIESefaz);
					}
				}
				if (parametros.getPossuiCnae().equals("S")) {					
					if (!consultaBaseSefazRepository.verificaPossuiCnaeEnvase(dto.getCadastro().getInscricaoEstadual(),
							parametros.getCnaeEnvase()
							)) {
						return new PreAnaliseResultado(false, 12, situacaoIESefaz);
					}
				}

			}
		}
		return new PreAnaliseResultado(true, situacaoIESefaz);
	}

}