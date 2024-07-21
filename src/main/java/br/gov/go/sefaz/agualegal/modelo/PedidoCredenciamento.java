package br.gov.go.sefaz.agualegal.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TAB_PEDIDO_CREDENCIAMENTO")
public class PedidoCredenciamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_credenciamento")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_credenciamento")
	private Credenciamento credenciamento;

	@Column(name = "numero_pedido")
	private Long numeroPedido;

	@Column(name = "data_pedido", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataPedido;

	@Column(name = "data_vencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "tipo_pedido", nullable = false)
	private Integer tipoPedido;

	@Column(name = "cnpj_grafica", length = 14)
	private String cnpjGrafica;

	@Column(name = "nome_grafica", length = 100)
	private String nomeGrafica;

	@Column(name = "data_deferimento")
	@Temporal(TemporalType.DATE)
	private Date dataDeferimento;

	@Column(name = "data_indeferimento")
	@Temporal(TemporalType.DATE)
	private Date dataIndeferimento;

	@Column(name = "motivo_indeferimento", length = 200)
	private String motivoIndeferimento;

	@Column(name = "observacao", length = 200)
	private String observacao;

	@OneToMany(mappedBy = "pedidoCredenciamento", cascade = CascadeType.ALL)
	private List<PedidoCampoForm> listaPedidoCampos = new ArrayList<PedidoCampoForm>();

	@OneToMany(mappedBy = "pedidoCredenciamento", cascade = CascadeType.ALL)
	private List<PedidoProduto> listaProdutos = new ArrayList<PedidoProduto>();

	public PedidoCredenciamento() {

	}

	public PedidoCredenciamento(Long id, Credenciamento credenciamento, Long numeroPedido, Date dataPedido,
			Date dataVencimento, Integer status, Integer tipoPedido, String cnpjGrafica, String nomeGrafica,
			Date dataDeferimento, Date dataIndeferimento, String motivoIndeferimento, String observacao,
			List<PedidoCampoForm> listaPedidoCampos, List<PedidoProduto> listaProdutos) {
		super();
		this.id = id;
		this.credenciamento = credenciamento;
		this.numeroPedido = numeroPedido;
		this.dataPedido = dataPedido;
		this.dataVencimento = dataVencimento;
		this.status = status;
		this.tipoPedido = tipoPedido;
		this.cnpjGrafica = cnpjGrafica;
		this.nomeGrafica = nomeGrafica;
		this.dataDeferimento = dataDeferimento;
		this.dataIndeferimento = dataIndeferimento;
		this.motivoIndeferimento = motivoIndeferimento;
		this.observacao = observacao;
		this.listaPedidoCampos = listaPedidoCampos;
		this.listaProdutos = listaProdutos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Credenciamento getCredenciamento() {
		return credenciamento;
	}

	public void setCredenciamento(Credenciamento credenciamento) {
		this.credenciamento = credenciamento;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(Integer tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getCnpjGrafica() {
		return cnpjGrafica;
	}

	public void setCnpjGrafica(String cnpjGrafica) {
		this.cnpjGrafica = cnpjGrafica;
	}

	public String getNomeGrafica() {
		return nomeGrafica;
	}

	public void setNomeGrafica(String nomeGrafica) {
		this.nomeGrafica = nomeGrafica;
	}

	public Date getDataDeferimento() {
		return dataDeferimento;
	}

	public void setDataDeferimento(Date dataDeferimento) {
		this.dataDeferimento = dataDeferimento;
	}

	public Date getDataIndeferimento() {
		return dataIndeferimento;
	}

	public void setDataIndeferimento(Date dataIndeferimento) {
		this.dataIndeferimento = dataIndeferimento;
	}

	public String getMotivoIndeferimento() {
		return motivoIndeferimento;
	}

	public void setMotivoIndeferimento(String motivoIndeferimento) {
		this.motivoIndeferimento = motivoIndeferimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<PedidoCampoForm> getListaPedidoCampos() {
		return listaPedidoCampos;
	}

	public void setListaPedidoCampos(List<PedidoCampoForm> listaPedidoCampos) {
		this.listaPedidoCampos = listaPedidoCampos;
	}

	public List<PedidoProduto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<PedidoProduto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpjGrafica, credenciamento, dataDeferimento, dataIndeferimento, dataPedido, dataVencimento,
				id, motivoIndeferimento, nomeGrafica, numeroPedido, observacao, status, tipoPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoCredenciamento other = (PedidoCredenciamento) obj;
		return Objects.equals(cnpjGrafica, other.cnpjGrafica) && Objects.equals(credenciamento, other.credenciamento)
				&& Objects.equals(dataDeferimento, other.dataDeferimento)
				&& Objects.equals(dataIndeferimento, other.dataIndeferimento)
				&& Objects.equals(dataPedido, other.dataPedido) && Objects.equals(dataVencimento, other.dataVencimento)
				&& Objects.equals(id, other.id) && Objects.equals(motivoIndeferimento, other.motivoIndeferimento)
				&& Objects.equals(nomeGrafica, other.nomeGrafica) && Objects.equals(numeroPedido, other.numeroPedido)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(status, other.status)
				&& Objects.equals(tipoPedido, other.tipoPedido);
	}

	@Override
	public String toString() {
		return "PedidoCredenciamento [id=" + id + ", credenciamento=" + credenciamento + ", numeroPedido="
				+ numeroPedido + ", dataPedido=" + dataPedido + ", dataVencimento=" + dataVencimento + ", status="
				+ status + ", tipoPedido=" + tipoPedido + ", cnpjGrafica=" + cnpjGrafica + ", nomeGrafica="
				+ nomeGrafica + ", dataDeferimento=" + dataDeferimento + ", dataIndeferimento=" + dataIndeferimento
				+ ", motivoIndeferimento=" + motivoIndeferimento + ", observacao=" + observacao + "]";
	}

}
