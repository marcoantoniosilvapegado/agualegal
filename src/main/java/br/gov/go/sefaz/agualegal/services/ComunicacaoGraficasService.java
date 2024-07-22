package br.gov.go.sefaz.agualegal.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.CampoResponseDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposRequestDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposResponseDTO;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.SolicitacaoCredenciamentoDTO;
import br.gov.go.sefaz.agualegal.enums.MENSAGENSPADRAO;
import br.gov.go.sefaz.agualegal.exception.EnvasadoraRegrasException;
import br.gov.go.sefaz.agualegal.exception.SolicitacaoCredenciamentoException;
import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;
import br.gov.go.sefaz.agualegal.modelo.Credenciamento;
import br.gov.go.sefaz.agualegal.modelo.PedidoCampoForm;
import br.gov.go.sefaz.agualegal.modelo.PedidoCredenciamento;
import br.gov.go.sefaz.agualegal.modelo.PedidoProduto;
import br.gov.go.sefaz.agualegal.repository.CampoFormularioRepository;
import br.gov.go.sefaz.agualegal.repository.ComunicacaoGraficasRepository;
import br.gov.go.sefaz.agualegal.repository.CredenciamentoRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class ComunicacaoGraficasService {

	private TokenGraficasService tokenGraficasService;

	private ComunicacaoGraficasRepository comunicacaoGraficasRepository;

	private CampoFormularioRepository campoFormularioRepository;
	
	private CredenciamentoRepository credenciamentoRepository;

	public ComunicacaoGraficasService(TokenGraficasService tokenGraficasService,
			ComunicacaoGraficasRepository comunicacaoGraficasRepository,
			CampoFormularioRepository campoFormularioRepository,
			CredenciamentoRepository credenciamentoRepository) {
		this.tokenGraficasService = tokenGraficasService;
		this.comunicacaoGraficasRepository = comunicacaoGraficasRepository;
		this.campoFormularioRepository = campoFormularioRepository;
		this.credenciamentoRepository = credenciamentoRepository;
	}

	public RespostaPadrao verificaSituacaoEnvasora(SituacaoEnvasadoraDTO dto) {

		/* Verifica se token da gráfica é válido */
		tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());

		/*
		 * Verifica se a envasadora está na lista de exceção Caso esteja, será concedida
		 * a permissão. Caso não, o fluxo seguirá e outras verificações serão feitas
		 */
		Boolean envasadoraListaExcecao = comunicacaoGraficasRepository
				.verificaEnvasadoraListaExcecao(dto.getInscricaoEstadual());

		if (envasadoraListaExcecao) {
			return new RespostaPadrao(MENSAGENSPADRAO.ENVASADORALISTAEXCECAO.getDesc(), 1, true);
		}

		/* Verifica inicialmente se a envasadora existe no cadastro */
		Boolean envasadoraExisteCadastro = comunicacaoGraficasRepository
				.verificaEnvasadoraExisteCadastro(dto.getInscricaoEstadual());

		if (!envasadoraExisteCadastro) {
			throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORANAOEXISTE.getDesc(), 2);
		}

		/* Verifica se a envasadora possui situação cadastral ativa */
		Boolean envasadoraCadastroAtivo = comunicacaoGraficasRepository
				.verificaEnvasadoraSituacaoAtiva(dto.getInscricaoEstadual());
		if (!envasadoraCadastroAtivo) {
			throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORASITFISCINATIVA.getDesc(), 3);
		}

		/* Verifica se a envasadora possui o CNAE de envasamento */
		Boolean envasadoraPossuiCnae = comunicacaoGraficasRepository
				.verificaEnvasadoraPossuiCnae(dto.getInscricaoEstadual());
		if (!envasadoraPossuiCnae) {
			throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORANAOINCLUIDACNAE.getDesc(), 5);
		}

		return new RespostaPadrao(MENSAGENSPADRAO.ENVASADORAPERMITIDA.getDesc(), 4, true);
	}

	public ListaCamposResponseDTO listaCamposEnvasadora(ListaCamposRequestDTO dto) {

		tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());
		List<CampoResponseDTO> listaCampos = comunicacaoGraficasRepository.listaCamposEnvasadora(dto.getTipoAgua());

		return new ListaCamposResponseDTO(listaCampos);
	}

	public RespostaPadrao solicitaCredenciamentoEnvasadora(SolicitacaoCredenciamentoDTO dto) {
		//tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());

		/*Pendente - será implementada camada de validação*/
		
		/*Salvar credenciamento*/
		Credenciamento credenciamento = this.salvaSolicitacaoCredenciamento(dto);
		return new RespostaPadrao(
				"Solicitação de credenciamento salva com sucesso! Código da solicitação: " + credenciamento.getId().toString(),
				1,
				true
				);		
	}

	@Transactional
	private Credenciamento salvaSolicitacaoCredenciamento(SolicitacaoCredenciamentoDTO dto) {

		/* Informações gerais do credenciamento */

		Credenciamento credenciamento = this.montaCredenciamento(dto);

		/* Informações de pedido */
		PedidoCredenciamento pedidoCredenciamento = this.montaPedido(dto, credenciamento);

		/* Informações sobre a lista de produtos */
		List<PedidoProduto> listaProdutos = dto.getListaProdutos().stream()
				.map(item -> new PedidoProduto(item, pedidoCredenciamento)).collect(Collectors.toList());
		pedidoCredenciamento.setListaProdutos(listaProdutos);

		/*Informações sobre lista de campos enviados - textuais e arquivos*/
		List<PedidoCampoForm> listaCampos = this.montaListaCamposForm(dto, pedidoCredenciamento);
		pedidoCredenciamento.setListaPedidoCampos(listaCampos);
		
		System.out.println(credenciamento.toString());

		try {
			return this.credenciamentoRepository.save(credenciamento);
		} catch (Exception e) {
			throw new SolicitacaoCredenciamentoException(e.getMessage());
		}
				
	}

	private Credenciamento montaCredenciamento(SolicitacaoCredenciamentoDTO dto) {
		Credenciamento credenciamento = new Credenciamento();

		credenciamento.setDataSolicitacao(new Date());
		credenciamento.setInscricaoEstadual(Long.parseLong(dto.getInscricaoEstadual()));
		credenciamento.setStatus(1);// solicitado
		credenciamento.setCnpj(UtilsAguaLegal.extracaoDadosListaCampos("CNPJ", dto));
		credenciamento.setRazaoSocial(UtilsAguaLegal.extracaoDadosListaCampos("Razão Social", dto));

		return credenciamento;

	}

	private PedidoCredenciamento montaPedido(SolicitacaoCredenciamentoDTO dto, Credenciamento credenciamento) {
		PedidoCredenciamento pedidoCredenciamento = new PedidoCredenciamento();
		pedidoCredenciamento.setDataPedido(new Date());
		pedidoCredenciamento.setCnpjGrafica(dto.getCnpjGrafica());
		pedidoCredenciamento.setNomeGrafica(dto.getNomeGrafica());
		pedidoCredenciamento.setTipoPedido(1);
		// Pendente - definir lógica de definição do vencimento
		pedidoCredenciamento.setDataVencimento(this.defineDataVencimento(30));
		pedidoCredenciamento.setNumeroPedido(this.defineNumeracaoPedido());
		pedidoCredenciamento.setObservacao(
				UtilsAguaLegal.extracaoDadosListaCampos("Observações da solicitação de credenciamento", dto));
		pedidoCredenciamento.setStatus(1);

		pedidoCredenciamento.setCredenciamento(credenciamento);
		credenciamento.addPedido(pedidoCredenciamento);

		return pedidoCredenciamento;
	}

	private List<PedidoCampoForm> montaListaCamposForm(SolicitacaoCredenciamentoDTO dto,
			PedidoCredenciamento pedidoCredenciamento) {

		/* Campos textuais */
		List<PedidoCampoForm> listaCamposTexto = dto.getListaCampos().stream().map(item -> {
			PedidoCampoForm pedidoCampoForm = new PedidoCampoForm();
			pedidoCampoForm.setPedidoCredenciamento(pedidoCredenciamento);

			Optional<CampoFormulario> campoFind = campoFormularioRepository
					.findCampoFormularioByNomeCriterio(item.getNomeCampo());
			if (!campoFind.isPresent()) {
				throw new EnvasadoraRegrasException(
						MENSAGENSPADRAO.CAMPONAOENCONTRADO.getDesc() + " - " + item.getNomeCampo(), 2);
			}
			pedidoCampoForm.setCampoFormulario(campoFind.get());
			pedidoCampoForm.setValorCampo(item.getConteudoCampo());

			return pedidoCampoForm;
		}).collect(Collectors.toList());

		/* Campos de arquivos enviados através do DTO */
		List<PedidoCampoForm> listaCamposArquivo = dto.getListaArquivos().stream().map(item -> {
			PedidoCampoForm pedidoCampoForm = new PedidoCampoForm();
			pedidoCampoForm.setPedidoCredenciamento(pedidoCredenciamento);

			Optional<CampoFormulario> campoFind = campoFormularioRepository
					.findCampoFormularioByNomeCriterio(item.getNomeCampo());
			if (!campoFind.isPresent()) {
				throw new EnvasadoraRegrasException(
						MENSAGENSPADRAO.CAMPONAOENCONTRADO.getDesc() + " - " + item.getNomeCampo(), 2);
			}
			pedidoCampoForm.setCampoFormulario(campoFind.get());
			pedidoCampoForm.setConteudoArquivo(item.getFile());

			return pedidoCampoForm;
		}).collect(Collectors.toList());
		List<PedidoCampoForm> listaRetorno = new ArrayList<>();
		listaRetorno.addAll(listaCamposArquivo);
		listaRetorno.addAll(listaCamposTexto);
		return listaRetorno;
	}

	public Date defineDataVencimento(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public Long defineNumeracaoPedido() {
		return 123456L;
	}

}
