package br.gov.go.sefaz.agualegal.modelo;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_PEDIDO_CREDENCIAMENTO")
public class PedidoCredenciamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido_credenciamento")
	@SequenceGenerator(name = "seq_pedido_credenciamento", sequenceName = "seq_tab_pedido_credenciamento", allocationSize = 1)
	@Column(name = "id_pedido_credenciamento")
	private Integer idPedidoCredenciamento;

	@Column(name = "data_pedido")
	@Temporal(TemporalType.DATE)
	private Date dataPedido;

	@Column(name = "data_vencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@Column(name = "data_analise")
	@Temporal(TemporalType.DATE)
	private Date dataAnalise;

	@Column(name = "numero_pedido")
	private Integer numeroPedido;

	@Column(name = "observacao", length = 200)
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "id_grafica", nullable = false)
	private Grafica grafica;

	@ManyToOne
	@JoinColumn(name = "id_status_pedido", nullable = false)
	private StatusAnalise statusPedido;

	@ManyToOne
	@JoinColumn(name = "id_tipo_pedido", nullable = false)
	private TipoPedido tipoPedido;

	@ManyToOne
	@JoinColumn(name = "id_credenciamento", nullable = false)
	private Credenciamento credenciamento;

	public PedidoCredenciamento() {
		
	}

	public Integer getIdPedidoCredenciamento() {
		return idPedidoCredenciamento;
	}

	public void setIdPedidoCredenciamento(Integer idPedidoCredenciamento) {
		this.idPedidoCredenciamento = idPedidoCredenciamento;
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

	public Date getDataAnalise() {
		return dataAnalise;
	}

	public void setDataAnalise(Date dataAnalise) {
		this.dataAnalise = dataAnalise;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}

	public StatusAnalise getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusAnalise statusPedido) {
		this.statusPedido = statusPedido;
	}

	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public Credenciamento getCredenciamento() {
		return credenciamento;
	}

	public void setCredenciamento(Credenciamento credenciamento) {
		this.credenciamento = credenciamento;
	}

	@Override
	public String toString() {
		return "PedidoCredenciamento [idPedidoCredenciamento=" + idPedidoCredenciamento + ", dataPedido=" + dataPedido
				+ ", dataVencimento=" + dataVencimento + ", dataAnalise=" + dataAnalise + ", numeroPedido="
				+ numeroPedido + ", observacao=" + observacao + ", grafica=" + grafica + ", statusPedido="
				+ statusPedido + ", tipoPedido=" + tipoPedido + ", credenciamento=" + credenciamento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(credenciamento, dataAnalise, dataPedido, dataVencimento, grafica, idPedidoCredenciamento,
				numeroPedido, observacao, statusPedido, tipoPedido);
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
		return Objects.equals(credenciamento, other.credenciamento) && Objects.equals(dataAnalise, other.dataAnalise)
				&& Objects.equals(dataPedido, other.dataPedido) && Objects.equals(dataVencimento, other.dataVencimento)
				&& Objects.equals(grafica, other.grafica)
				&& Objects.equals(idPedidoCredenciamento, other.idPedidoCredenciamento)
				&& Objects.equals(numeroPedido, other.numeroPedido) && Objects.equals(observacao, other.observacao)
				&& Objects.equals(statusPedido, other.statusPedido) && Objects.equals(tipoPedido, other.tipoPedido);
	}

}
