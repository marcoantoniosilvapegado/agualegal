package br.gov.go.sefaz.agualegal.modelonew;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ANALISE_PEDIDO")
public class AnalisePedido {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_analise_pedido")
	@SequenceGenerator(name = "seq_analise_pedido", sequenceName = "seq_tab_analise_pedido", allocationSize = 1)
	@Column(name = "id_analise_pedido")
	private Integer idAnalisePedido;

	@Column(name = "data_analise")
	private java.sql.Date dataAnalise;

	@ManyToOne
	@JoinColumn(name = "id_tipo_analise", nullable = false)
	private TipoAnalise tipoAnalise;

	@ManyToOne
	@JoinColumn(name = "id_status_analise", nullable = false)
	private StatusAnalise statusAnalise;

	@ManyToOne
	@JoinColumn(name = "id_motivo_indeferimento")
	private MotivoIndeferimento motivoIndeferimento;

	@ManyToOne
	@JoinColumn(name = "id_pedido_credenciamento", nullable = false)
	private PedidoCredenciamento pedidoCredenciamento;

	public AnalisePedido() {
		
	}

	public Integer getIdAnalisePedido() {
		return idAnalisePedido;
	}

	public void setIdAnalisePedido(Integer idAnalisePedido) {
		this.idAnalisePedido = idAnalisePedido;
	}

	public java.sql.Date getDataAnalise() {
		return dataAnalise;
	}

	public void setDataAnalise(java.sql.Date dataAnalise) {
		this.dataAnalise = dataAnalise;
	}

	public TipoAnalise getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(TipoAnalise tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	public StatusAnalise getStatusAnalise() {
		return statusAnalise;
	}

	public void setStatusAnalise(StatusAnalise statusAnalise) {
		this.statusAnalise = statusAnalise;
	}

	public MotivoIndeferimento getMotivoIndeferimento() {
		return motivoIndeferimento;
	}

	public void setMotivoIndeferimento(MotivoIndeferimento motivoIndeferimento) {
		this.motivoIndeferimento = motivoIndeferimento;
	}

	public PedidoCredenciamento getPedidoCredenciamento() {
		return pedidoCredenciamento;
	}

	public void setPedidoCredenciamento(PedidoCredenciamento pedidoCredenciamento) {
		this.pedidoCredenciamento = pedidoCredenciamento;
	}

	@Override
	public String toString() {
		return "AnalisePedido [idAnalisePedido=" + idAnalisePedido + ", dataAnalise=" + dataAnalise + ", tipoAnalise="
				+ tipoAnalise + ", statusAnalise=" + statusAnalise + ", motivoIndeferimento=" + motivoIndeferimento
				+ ", pedidoCredenciamento=" + pedidoCredenciamento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataAnalise, idAnalisePedido, motivoIndeferimento, pedidoCredenciamento, statusAnalise,
				tipoAnalise);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnalisePedido other = (AnalisePedido) obj;
		return Objects.equals(dataAnalise, other.dataAnalise) && Objects.equals(idAnalisePedido, other.idAnalisePedido)
				&& Objects.equals(motivoIndeferimento, other.motivoIndeferimento)
				&& Objects.equals(pedidoCredenciamento, other.pedidoCredenciamento)
				&& Objects.equals(statusAnalise, other.statusAnalise) && Objects.equals(tipoAnalise, other.tipoAnalise);
	}

}