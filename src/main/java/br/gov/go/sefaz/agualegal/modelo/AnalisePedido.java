package br.gov.go.sefaz.agualegal.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_ANALISE_PEDIDO")
public class AnalisePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_analise_pedido")
	@SequenceGenerator(name = "seq_analise_pedido", sequenceName = "APL_AGUALEGAL.seq_tab_analise_pedido", allocationSize = 1)
	@Column(name = "id_analise_pedido")
	private Integer idAnalisePedido;

	@Column(name = "data_analise")
	private Date dataAnalise;

	@ManyToOne
	@JoinColumn(name = "id_tipo_analise", nullable = false)
	private TipoAnalise tipoAnalise;

	@ManyToOne
	@JoinColumn(name = "id_status_analise", nullable = false)
	private StatusAnalise statusAnalise;

	@OneToMany
	@JoinColumn(name = "ID_MOTIVO_INDEFERIMENTO")
	private List<MotivoIndeferimento> motivoIndeferimento = new ArrayList<MotivoIndeferimento>();

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

	public Date getDataAnalise() {
		return dataAnalise;
	}

	public void setDataAnalise(Date dataAnalise) {
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

	public PedidoCredenciamento getPedidoCredenciamento() {
		return pedidoCredenciamento;
	}

	public void setPedidoCredenciamento(PedidoCredenciamento pedidoCredenciamento) {
		this.pedidoCredenciamento = pedidoCredenciamento;
	}

	public List<MotivoIndeferimento> getMotivoIndeferimento() {
		return motivoIndeferimento;
	}

	public void setMotivoIndeferimento(List<MotivoIndeferimento> motivoIndeferimento) {
		this.motivoIndeferimento = motivoIndeferimento;
	}
	

}