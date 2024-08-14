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

	public PreAnaliseService(GraficaRepository graficaRepository, 
			IeExcecaoRepository ieExcecaoRepository,
			ParPreAnaliseRepository parPreAnaliseRepository,
			ConsultaBaseSefazRepository consultaBaseSefazRepository) {
		this.graficaRepository = graficaRepository;
		this.ieExcecaoRepository = ieExcecaoRepository;
		this.parPreAnaliseRepository = parPreAnaliseRepository;
		this.consultaBaseSefazRepository = consultaBaseSefazRepository;
	}

	public PreAnaliseResultado preAnaliseEnvasadora(DadosSolicitacaoDTO dto) throws PreAnaliseException {

		/* Valida inicialmente se existe a gráfica na base */
		Optional<Grafica> buscaCpfCnpjGrafica = this.graficaRepository.findByCnpj(dto.getCnpjGrafica());
		if (buscaCpfCnpjGrafica.isEmpty()) {
			return new PreAnaliseResultado(false, 7);
		}
		
		String tokenConvertidoMDS = UtilsAguaLegal.converteSHA256(dto.getTokenGrafica());
		/* Valida se o token está correto */
		Optional<Grafica> validaTokenGrafica = this.graficaRepository.findByTokenAndCnpj(tokenConvertidoMDS,
				dto.getCnpjGrafica());
		if (validaTokenGrafica.isEmpty()) {
			return new PreAnaliseResultado(false, 8);
		}

		/* Verificar se é válido o CNPJ da envasadora */
		if (UtilsAguaLegal.isEmpty(dto.getCadastro().getCnpj())
				|| !UtilsAguaLegal.verificaCnpjValido(dto.getCadastro().getCnpj())) {
			return new PreAnaliseResultado(false, 9);
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
						return new PreAnaliseResultado(false, 10);
					}

				}
				if (parametros.getSituacaoFiscAtiva().equals("S")) {					
					if (!consultaBaseSefazRepository.verificaSituacaoFiscalAtiva(dto.getCadastro().getInscricaoEstadual())) {
						return new PreAnaliseResultado(false, 11);
					}
				}
				if (parametros.getPossuiCnae().equals("S")) {					
					if (!consultaBaseSefazRepository.verificaPossuiCnaeEnvase(dto.getCadastro().getInscricaoEstadual(),
							parametros.getCnaeEnvase()
							)) {
						return new PreAnaliseResultado(false, 12);
					}
				}

			}
		}
		return new PreAnaliseResultado(true);
	}

}