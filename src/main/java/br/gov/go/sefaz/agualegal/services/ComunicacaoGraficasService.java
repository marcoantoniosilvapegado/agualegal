package br.gov.go.sefaz.agualegal.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.CampoResponseDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposRequestDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposResponseDTO;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.CadastroDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ResponsavelDTO;
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

//@Service
public class ComunicacaoGraficasService {

	/*private TokenGraficasService tokenGraficasService;

	private ComunicacaoGraficasRepository comunicacaoGraficasRepository;

	private CampoFormularioRepository campoFormularioRepository;

	private CredenciamentoRepository credenciamentoRepository;

	private ValidacaoSolicitacaoCredenciamento validacaoSolicitacaoCredenciamento;

	public ComunicacaoGraficasService(TokenGraficasService tokenGraficasService,
			ComunicacaoGraficasRepository comunicacaoGraficasRepository,
			CampoFormularioRepository campoFormularioRepository, CredenciamentoRepository credenciamentoRepository,
			ValidacaoSolicitacaoCredenciamento validacaoSolicitacaoCredenciamento) {
		this.tokenGraficasService = tokenGraficasService;
		this.comunicacaoGraficasRepository = comunicacaoGraficasRepository;
		this.campoFormularioRepository = campoFormularioRepository;
		this.credenciamentoRepository = credenciamentoRepository;
		this.validacaoSolicitacaoCredenciamento = validacaoSolicitacaoCredenciamento;
	}

/*	public RespostaPadrao verificaSituacaoEnvasora(SituacaoEnvasadoraDTO dto) {

		tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());
		
	
		Boolean envasadoraListaExcecao = comunicacaoGraficasRepository
				.verificaEnvasadoraListaExcecao(dto.getInscricaoEstadual());

		if (envasadoraListaExcecao) {
			return new RespostaPadrao(MENSAGENSPADRAO.ENVASADORALISTAEXCECAO.getDesc(), 1, true);
		}

		Boolean envasadoraExisteCadastro = comunicacaoGraficasRepository
				.verificaEnvasadoraExisteCadastro(dto.getInscricaoEstadual());

		if (!envasadoraExisteCadastro) {
			throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORANAOEXISTE.getDesc(), 2);
		}

		Boolean envasadoraCadastroAtivo = comunicacaoGraficasRepository
				.verificaEnvasadoraSituacaoAtiva(dto.getInscricaoEstadual());
		if (!envasadoraCadastroAtivo) {
			throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORASITFISCINATIVA.getDesc(), 3);
		}

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
*/
	/*public RespostaPadrao solicitaCredenciamentoEnvasadora(DadosSolicitacaoDTO dto) {
		
		this.validacaoSolicitacaoCredenciamento.validacaoDadosSolicitacaoCredenciamento(dto);
		
		
		Credenciamento credenciamento = this.salvaSolicitacaoCredenciamento(dto);
		return new RespostaPadrao("Solicitação de credenciamento salva com sucesso! Código da solicitação: "
				+ credenciamento.getId().toString(), 1, true);
	}*/

//	@Transactional
	/*private Credenciamento salvaSolicitacaoCredenciamento(DadosSolicitacaoDTO dto) {


		Credenciamento credenciamento = this.montaCredenciamento(dto);

		PedidoCredenciamento pedidoCredenciamento = this.montaPedido(dto, credenciamento);

		List<PedidoProduto> listaProdutos = dto.getListaProdutos().stream()
				.map(item -> new PedidoProduto(item, pedidoCredenciamento)).collect(Collectors.toList());
		pedidoCredenciamento.setListaProdutos(listaProdutos);

		List<PedidoCampoForm> listaCampos = this.montaListaCamposForm(dto, pedidoCredenciamento);
		pedidoCredenciamento.setListaPedidoCampos(listaCampos);

		System.out.println(credenciamento.toString());

		try {
			return this.credenciamentoRepository.save(credenciamento);
		} catch (Exception e) {
			throw new SolicitacaoCredenciamentoException(e.getMessage());
		}

	}*/

	/*private Credenciamento montaCredenciamento(DadosSolicitacaoDTO dto) {
		Credenciamento credenciamento = new Credenciamento();

		String cnpjEnvasadora = dto.getCadastro().getCnpj(); 
		
		Integer solicitacoes = credenciamentoRepository.verificaSolicitacaoVigente(cnpjEnvasadora);
		if (solicitacoes > 0) {
			throw new SolicitacaoCredenciamentoException(
					"Já existe uma solicitação de credenciamento vigente para este CNPJ", 1);
		}
		credenciamento.setCnpj(cnpjEnvasadora);
		credenciamento.setDataSolicitacao(new Date());
		credenciamento.setInscricaoEstadual(Long.parseLong(dto.getCadastro().getInscricaoEstadual()));
		credenciamento.setStatus(1);// solicitado

		credenciamento.setRazaoSocial(dto.getCadastro().getRazaoSocial());

		return credenciamento;

	}*/

	/*private PedidoCredenciamento montaPedido(DadosSolicitacaoDTO dto, Credenciamento credenciamento) {
		PedidoCredenciamento pedidoCredenciamento = new PedidoCredenciamento();
		pedidoCredenciamento.setDataPedido(new Date());

		pedidoCredenciamento.setCnpjGrafica("35113067000117");
		pedidoCredenciamento.setNomeGrafica("GRAFICA E EDITORA SAO LUIS LTDA");

		pedidoCredenciamento.setTipoPedido(1);
		pedidoCredenciamento.setDataVencimento(null);
		pedidoCredenciamento.setNumeroPedido(this.defineNumeracaoPedido());

		pedidoCredenciamento.setObservacao(UtilsAguaLegal.isEmpty(dto.getObservacao()) ? "" : dto.getObservacao());
		pedidoCredenciamento.setStatus(1);

		pedidoCredenciamento.setCredenciamento(credenciamento);
		credenciamento.addPedido(pedidoCredenciamento);

		return pedidoCredenciamento;
	}
*//*
	private List<PedidoCampoForm> montaListaCamposForm(DadosSolicitacaoDTO dto,
			PedidoCredenciamento pedidoCredenciamento) {

		List<CampoFormulario> listaCamposConfigurados = campoFormularioRepository.findAll();
		List<PedidoCampoForm> listaPedidos = new ArrayList<>();

		List<PedidoCampoForm> listaPedidosCadastro = this.montaListaPedidosCampoFormCadastro(dto.getCadastro(),
				pedidoCredenciamento, listaCamposConfigurados);
		List<PedidoCampoForm> listaPedidosResponsavel = this.montaListaPedidosCampoResponsavelCadastro(
				dto.getResponsavel(), pedidoCredenciamento, listaCamposConfigurados);
		List<PedidoCampoForm> listaPedidosLicenca = this.montaPedidosLicenca(dto, pedidoCredenciamento,
				listaCamposConfigurados);
		List<PedidoCampoForm> listaEndereco = this.montaListaPedidosCampoFormEndereco(dto, pedidoCredenciamento,
				listaCamposConfigurados);
		List<PedidoCampoForm> listaRestantes = this.montaListaItensRestantes(dto, pedidoCredenciamento, listaCamposConfigurados);
		
		listaPedidos.addAll(listaPedidosCadastro);
		listaPedidos.addAll(listaPedidosResponsavel);
		listaPedidos.addAll(listaPedidosLicenca);
		listaPedidos.addAll(listaEndereco);
		listaPedidos.addAll(listaRestantes);		
		
		return listaPedidos;
	}*/

/*	private List<PedidoCampoForm> montaListaItensRestantes(DadosSolicitacaoDTO dto,
			PedidoCredenciamento pedidoCredenciamento, List<CampoFormulario> listaCamposConfigurados) {

		List<PedidoCampoForm> listaRetorno = new ArrayList<>();

		PedidoCampoForm pedidoCampoFormTipoAgua = new PedidoCampoForm(pedidoCredenciamento, dto.getTipoAgua(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(19L))
						.collect(Collectors.toList()).get(0));
		listaRetorno.add(pedidoCampoFormTipoAgua);

		if (!UtilsAguaLegal.isEmpty(dto.getObservacao())) {
			PedidoCampoForm pedidoCampoFormObservacao = new PedidoCampoForm(pedidoCredenciamento, dto.getObservacao(),
					listaCamposConfigurados.stream().filter(item -> item.getId().equals(20L))
							.collect(Collectors.toList()).get(0));
			listaRetorno.add(pedidoCampoFormObservacao);
		}

		return listaRetorno;
	}

	private List<PedidoCampoForm> montaPedidosLicenca(DadosSolicitacaoDTO dto,
			PedidoCredenciamento pedidoCredenciamento, List<CampoFormulario> listaCamposConfigurados) {

		List<PedidoCampoForm> listaCampoForms = new ArrayList<>();

		PedidoCampoForm pedidoCampoFormEmissorLicenca = new PedidoCampoForm(pedidoCredenciamento,
				dto.getLicencaVigilancia().getEmissor(),
				listaCamposConfigurados.stream()
						.filter(item -> item.getId().equals(10L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormNumeroLicenca = new PedidoCampoForm(pedidoCredenciamento,
				dto.getLicencaVigilancia().getNumero(),
				listaCamposConfigurados.stream()
						.filter(item -> item.getId().equals(12L))			
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormImagemLicenca = new PedidoCampoForm(pedidoCredenciamento,
				dto.getLicencaVigilancia().getImagem(),
				listaCamposConfigurados.stream()
						.filter(item -> item.getId().equals(11L))
						.collect(Collectors.toList()).get(0));

		listaCampoForms.addAll(Arrays.asList(pedidoCampoFormEmissorLicenca, pedidoCampoFormNumeroLicenca,
				pedidoCampoFormImagemLicenca));

		if (dto.getLicencaMineracao() != null) {
			PedidoCampoForm pedidoCampoFormNumeroLicencaMineracao = new PedidoCampoForm(pedidoCredenciamento,
					dto.getLicencaMineracao().getNumero(),
					listaCamposConfigurados.stream()
							.filter(item -> item.getId().equals(14L))
							.collect(Collectors.toList()).get(0));

			PedidoCampoForm pedidoCampoFormImagemLicencaMineracao = new PedidoCampoForm(pedidoCredenciamento,
					dto.getLicencaMineracao().getImagem(),
					listaCamposConfigurados.stream()
							.filter(item -> item.getId().equals(13L))
							.collect(Collectors.toList()).get(0));

			listaCampoForms.addAll(
					Arrays.asList(pedidoCampoFormNumeroLicencaMineracao, pedidoCampoFormImagemLicencaMineracao));
		}

		return listaCampoForms;

	}

	private List<PedidoCampoForm> montaListaPedidosCampoFormCadastro(CadastroDTO dto,
			PedidoCredenciamento pedidoCredenciamento, List<CampoFormulario> listaCamposConfigurados) {

		PedidoCampoForm pedidoCampoFormCnpj = new PedidoCampoForm(pedidoCredenciamento, dto.getCnpj(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(1L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormRazaoSocial = new PedidoCampoForm(pedidoCredenciamento, dto.getRazaoSocial(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(2L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormInscricaoEstadual = new PedidoCampoForm(pedidoCredenciamento,
				dto.getInscricaoEstadual(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(4L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormNomeFantasia = new PedidoCampoForm(pedidoCredenciamento, dto.getNomeFantasia(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(3L))
						.collect(Collectors.toList()).get(0));

		return Arrays.asList(pedidoCampoFormCnpj, pedidoCampoFormInscricaoEstadual, pedidoCampoFormNomeFantasia,
				pedidoCampoFormRazaoSocial);

	}

	private List<PedidoCampoForm> montaListaPedidosCampoFormEndereco(DadosSolicitacaoDTO dto,
			PedidoCredenciamento pedidoCredenciamento, List<CampoFormulario> listaCamposConfigurados) {

		PedidoCampoForm pedidoCampoFormEnderecoEnvasadora = new PedidoCampoForm(pedidoCredenciamento,
				dto.getEnderecoEnvasador(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(15L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormCoordenadasEnvasadora = new PedidoCampoForm(pedidoCredenciamento,
				dto.getCoordenadasEnvasador(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(16L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormEnderecoLocalEnvase = new PedidoCampoForm(pedidoCredenciamento,
				dto.getEnderecoEnvase(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(17L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormCoordenadasEnvase = new PedidoCampoForm(pedidoCredenciamento,
				dto.getCoordenadasEnvase(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(18L))
						.collect(Collectors.toList()).get(0));

		return Arrays.asList(pedidoCampoFormEnderecoEnvasadora, pedidoCampoFormCoordenadasEnvasadora,
				pedidoCampoFormEnderecoLocalEnvase, pedidoCampoFormCoordenadasEnvase);

	}

	private List<PedidoCampoForm> montaListaPedidosCampoResponsavelCadastro(ResponsavelDTO dto,
			PedidoCredenciamento pedidoCredenciamento, List<CampoFormulario> listaCamposConfigurados) {

		PedidoCampoForm pedidoCampoFormNomeResponsavel = new PedidoCampoForm(pedidoCredenciamento,
				dto.getNomeResponsavel(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(5L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormEmailResponsavel = new PedidoCampoForm(pedidoCredenciamento,
				dto.getEmailResponsavel(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(6L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormRgResponsavel = new PedidoCampoForm(pedidoCredenciamento, dto.getRgResponsavel(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(7L))
						.collect(Collectors.toList()).get(0));

		PedidoCampoForm pedidoCampoFormCpfResponsavel = new PedidoCampoForm(pedidoCredenciamento,
				dto.getCpfResponsavel(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(8L))
						.collect(Collectors.toList()).get(0));
		PedidoCampoForm pedidoCampoFormTelefoneResponsavel = new PedidoCampoForm(pedidoCredenciamento,
				dto.getTelefoneResponsavel(),
				listaCamposConfigurados.stream().filter(item -> item.getId().equals(9L))
						.collect(Collectors.toList()).get(0));

		return Arrays.asList(pedidoCampoFormNomeResponsavel, pedidoCampoFormEmailResponsavel,
				pedidoCampoFormRgResponsavel, pedidoCampoFormCpfResponsavel, pedidoCampoFormTelefoneResponsavel);

	}

	public Date defineDataVencimento(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public Long defineNumeracaoPedido() {
		return 123456L;
	}
*/
}
