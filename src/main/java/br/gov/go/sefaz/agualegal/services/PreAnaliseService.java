package br.gov.go.sefaz.agualegal.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.domain.PreAnaliseResultado;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.exception.ParametrosNaoConfiguradosException;
import br.gov.go.sefaz.agualegal.exception.PreAnaliseException;
import br.gov.go.sefaz.agualegal.modelo.Cadastro;
import br.gov.go.sefaz.agualegal.modelo.CadastroCnae;
import br.gov.go.sefaz.agualegal.modelo.Grafica;
import br.gov.go.sefaz.agualegal.modelo.IeExcecao;
import br.gov.go.sefaz.agualegal.modelo.ParPreAnalise;
import br.gov.go.sefaz.agualegal.repository.CadastroCnaeRepository;
import br.gov.go.sefaz.agualegal.repository.CadastroRepository;
import br.gov.go.sefaz.agualegal.repository.GraficaRepository;
import br.gov.go.sefaz.agualegal.repository.IeExcecaoRepository;
import br.gov.go.sefaz.agualegal.repository.ParPreAnaliseRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class PreAnaliseService {

	private GraficaRepository graficaRepository;
	private IeExcecaoRepository ieExcecaoRepository;
	private ParPreAnaliseRepository parPreAnaliseRepository;
	private CadastroCnaeRepository cadastroCnaeRepository;
	private CadastroRepository cadastroRepository;

	public PreAnaliseService(GraficaRepository graficaRepository, IeExcecaoRepository ieExcecaoRepository,
			ParPreAnaliseRepository parPreAnaliseRepository, CadastroCnaeRepository cadastroCnaeRepository,
			CadastroRepository cadastroRepository) {
		this.graficaRepository = graficaRepository;
		this.ieExcecaoRepository = ieExcecaoRepository;
		this.parPreAnaliseRepository = parPreAnaliseRepository;
		this.cadastroCnaeRepository = cadastroCnaeRepository;
		this.cadastroRepository = cadastroRepository;
	}

	public PreAnaliseResultado preAnaliseEnvasadora(DadosSolicitacaoDTO dto) throws PreAnaliseException {

		/* Valida inicialmente se existe a gráfica na base */
		Optional<Grafica> buscaCpfCnpjGrafica = this.graficaRepository.findByCnpj(dto.getCnpjGrafica());
		if (buscaCpfCnpjGrafica.isEmpty()) {
			return new PreAnaliseResultado(false, 7);
		}
		/* Valida se o token está correto */
		Optional<Grafica> validaTokenGrafica = this.graficaRepository.findByTokenAndCnpj(dto.getTokenGrafica(),
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
					Optional<Cadastro> buscaCnpj = this.cadastroRepository.findByCnpj(dto.getCadastro().getCnpj());
					if (buscaCnpj.isEmpty()) {
						return new PreAnaliseResultado(false, 10);
					}

				}
				if (parametros.getSituacaoFiscAtiva().equals("S")) {
					Optional<Cadastro> buscaSituacao = this.cadastroRepository
							.findByCnpjAndSituacaoFiscal(dto.getCadastro().getCnpj(), 1);
					if (buscaSituacao.isEmpty()) {
						return new PreAnaliseResultado(false, 11);
					}
				}
				if (parametros.getPossuiCnae().equals("S")) {
					CadastroCnae buscaCnae = this.cadastroCnaeRepository
							.findByCnae(dto.getCadastro().getCnpj(), Long.parseLong(parametros.getCnaeEnvase()));
					if (buscaCnae == null) {
						return new PreAnaliseResultado(false, 12);
					}
				}

			}
		}
		return new PreAnaliseResultado(true);
	}

}
