package br.gov.go.sefaz.agualegal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.exception.SolicitacaoCredenciamentoException;
import br.gov.go.sefaz.agualegal.modelonew.Credenciamento;
import br.gov.go.sefaz.agualegal.modelonew.DadosPedido;
import br.gov.go.sefaz.agualegal.modelonew.Envasadora;
import br.gov.go.sefaz.agualegal.modelonew.Grafica;
import br.gov.go.sefaz.agualegal.modelonew.PedidoCredenciamento;
import br.gov.go.sefaz.agualegal.modelonew.StatusCredenciamento;
import br.gov.go.sefaz.agualegal.modelonew.TipoAgua;
import br.gov.go.sefaz.agualegal.repositorynew.CredenciamentoRepository;
import br.gov.go.sefaz.agualegal.repositorynew.DadosPedidoRepository;
import br.gov.go.sefaz.agualegal.repositorynew.EnvasadoraRepository;
import br.gov.go.sefaz.agualegal.repositorynew.GraficaRepository;
import br.gov.go.sefaz.agualegal.repositorynew.PedidoCredenciamentoRepository;
import br.gov.go.sefaz.agualegal.repositorynew.StatusAnaliseRepository;
import br.gov.go.sefaz.agualegal.repositorynew.StatusCredenciamentoRepository;
import br.gov.go.sefaz.agualegal.repositorynew.TipoAguaRepository;
import br.gov.go.sefaz.agualegal.repositorynew.TipoPedidoRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class CredenciamentoEnvasadoraService {

	private EnvasadoraRepository envasadoraRepository;
	private TipoAguaRepository tipoAguaRepository;
	private StatusCredenciamentoRepository statusCredenciamentoRepository;
	private CredenciamentoRepository credenciamentoRepository;
	private GraficaRepository graficaRepository;
	private StatusAnaliseRepository statusAnaliseRepository;
	private TipoPedidoRepository tipoPedidoRepository;
	private PedidoCredenciamentoRepository pedidoCredenciamentoRepository;
	private DadosPedidoRepository dadosPedidoRepository;
	private ValidacaoSolicitacaoCredenciamentoNew validacaoSolicitacaoCredenciamentoNew;

	public CredenciamentoEnvasadoraService(EnvasadoraRepository envasadoraRepository,
			TipoAguaRepository tipoAguaRepository, StatusCredenciamentoRepository statusCredenciamentoRepository,
			CredenciamentoRepository credenciamentoRepository, GraficaRepository graficaRepository,
			StatusAnaliseRepository statusAnaliseRepository, TipoPedidoRepository tipoPedidoRepository,
			PedidoCredenciamentoRepository pedidoCredenciamentoRepository, DadosPedidoRepository dadosPedidoRepository,
			ValidacaoSolicitacaoCredenciamentoNew validacaoSolicitacaoCredenciamentoNew) {
		super();
		this.envasadoraRepository = envasadoraRepository;
		this.tipoAguaRepository = tipoAguaRepository;
		this.statusCredenciamentoRepository = statusCredenciamentoRepository;
		this.credenciamentoRepository = credenciamentoRepository;
		this.graficaRepository = graficaRepository;
		this.statusAnaliseRepository = statusAnaliseRepository;
		this.tipoPedidoRepository = tipoPedidoRepository;
		this.pedidoCredenciamentoRepository = pedidoCredenciamentoRepository;
		this.dadosPedidoRepository = dadosPedidoRepository;
		this.validacaoSolicitacaoCredenciamentoNew = validacaoSolicitacaoCredenciamentoNew;
	}

	@Transactional
	public RespostaPadrao solicitaCredenciamentoEnvasadora(DadosSolicitacaoDTO dto) {
		/* Validação dos dados recebidos na solicitação de credenciamento */
		this.validacaoSolicitacaoCredenciamentoNew.validacaoDadosSolicitacaoCredenciamento(dto);

		TipoAgua tipoAgua = tipoAguaRepository.findById(Integer.parseInt(dto.getTipoAgua())).orElseThrow(
				() -> new SolicitacaoCredenciamentoException("Tipo de água não encontrado: " + dto.getTipoAgua(), 1));

		/* Verificação de solicitação de credenciamento vigente */

		Integer qtdSolicitacaoVigente = this.credenciamentoRepository
				.verificaSolicitacaoCredenciamentoVigente(dto.getCadastro().getCnpj());
		if (qtdSolicitacaoVigente > 0) {
			throw new SolicitacaoCredenciamentoException(
					"Já existe uma solicitação de credenciamento para o cnpj " + dto.getCadastro().getCnpj(), 1);
		}

		/* Verificação de credenciamento ativo */
		Integer qtdCredenciamentoAtivo = this.credenciamentoRepository
				.verificaCredeciamentoAtivo(dto.getCadastro().getCnpj());
		if (qtdCredenciamentoAtivo > 0) {
			throw new SolicitacaoCredenciamentoException(
					"Já existe um credenciamento ativo para o cnpj " + dto.getCadastro().getCnpj(), 1);
		}

		Envasadora envasadora = this.persistenciaEnvasadora(dto, tipoAgua);
		Credenciamento credenciamento = persistenciaCredenciamento(dto, envasadora);
		PedidoCredenciamento pedido = persistenciaPedidoCredenciamento(dto, credenciamento);
		persistenciaDadosPedido(dto, pedido);

		return new RespostaPadrao("Solicitação de credenciamento salva com sucesso! Código da solicitação: "
				+ credenciamento.getIdCredenciamento(), 1, true);
	}

	private DadosPedido persistenciaDadosPedido(DadosSolicitacaoDTO dto, PedidoCredenciamento pedido) {
		DadosPedido dadosPedido = new DadosPedido();

		dadosPedido.setPedidoCredenciamento(pedido);

		dadosPedido.setJsonResponsavel(UtilsAguaLegal.toJson(dto.getResponsavel()));
		dadosPedido.setJsonEnvasadora(UtilsAguaLegal.toJson(dto.getCadastro()));
		dadosPedido.setJsonProdutos(UtilsAguaLegal.toJson(dto.getListaProdutos()));
		dadosPedido.setJsonLicencas(UtilsAguaLegal.toJson(dto.getListaLicencas()));
		return this.dadosPedidoRepository.save(dadosPedido);

	}

	private PedidoCredenciamento persistenciaPedidoCredenciamento(DadosSolicitacaoDTO dto,
			Credenciamento credenciamento) {

		Grafica grafica = this.graficaRepository.findByCnpj(dto.getCnpjGrafica())
				.orElseThrow(() -> new SolicitacaoCredenciamentoException("Gráfica não encontrada na base!", 1));

		PedidoCredenciamento pedidoCredenciamento = new PedidoCredenciamento();

		pedidoCredenciamento.setCredenciamento(credenciamento);
		pedidoCredenciamento.setDataPedido(new Date());
		pedidoCredenciamento.setNumeroPedido(123457);

		pedidoCredenciamento.setObservacao(UtilsAguaLegal.isEmpty(dto.getObservacao()) ? "" : dto.getObservacao());
		pedidoCredenciamento.setGrafica(grafica);
		pedidoCredenciamento.setStatusPedido(this.statusAnaliseRepository.findById(1).get());
		pedidoCredenciamento.setTipoPedido(this.tipoPedidoRepository.findById(1).get());

		return this.pedidoCredenciamentoRepository.save(pedidoCredenciamento);

	}

	private Credenciamento persistenciaCredenciamento(DadosSolicitacaoDTO dto, Envasadora envasadora) {

		/*
		 * Registro de credenciamento nasce inativo. Ficará ativo se for deferido pelos
		 * fiscais
		 */
		Optional<StatusCredenciamento> statusInativo = this.statusCredenciamentoRepository.findById(2);

		Credenciamento credenciamento = new Credenciamento();
		credenciamento.setEnvasadora(envasadora);
		credenciamento.setStatusCredenciamento(statusInativo.get());

		return this.credenciamentoRepository.save(credenciamento);

	}

	private Envasadora persistenciaEnvasadora(DadosSolicitacaoDTO dto, TipoAgua tipoAgua) {
		/* Será verificado se a envasadora já existe na base */
		Optional<Envasadora> envasadora = envasadoraRepository.findByCnpj(dto.getCadastro().getCnpj());
		if (envasadora.isPresent()) {
			return envasadora.get();
		}
		/* Caso não, será criado registro na tabela TAB_ENVASADORA */
		Envasadora envasadoraPersist = new Envasadora(dto.getCadastro(), tipoAgua);
		return this.envasadoraRepository.save(envasadoraPersist);
	}

}
