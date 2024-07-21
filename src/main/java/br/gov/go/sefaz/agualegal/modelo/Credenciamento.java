package br.gov.go.sefaz.agualegal.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TAB_CREDENCIAMENTO")
public class Credenciamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CREDENCIAMENTO")
	private Long id;

	@Column(name = "IE", nullable = false)
	private Long inscricaoEstadual;

	@Column(name = "RAZAO_SOCIAL", nullable = false, length = 100)
	private String razaoSocial;

	@Column(name = "DATA_SOLICITACAO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataSolicitacao;

	@Column(name = "CNPJ", nullable = false, length = 14)
	private String cnpj;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "DATA_INICIO")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "DATA_FIM")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@OneToMany(mappedBy = "credenciamento", cascade = CascadeType.ALL)
	private List<PedidoCredenciamento> pedidos = new ArrayList<>();

	public void addPedido(PedidoCredenciamento pedido) {
		pedidos.add(pedido);
		pedido.setCredenciamento(this);
	}

	public Credenciamento() {
		// TODO Auto-generated constructor stub
	}
	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(Long inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<PedidoCredenciamento> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoCredenciamento> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Credenciamento [id=" + id + ", inscricaoEstadual=" + inscricaoEstadual + ", razaoSocial=" + razaoSocial
				+ ", dataSolicitacao=" + dataSolicitacao + ", cnpj=" + cnpj + ", status=" + status + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + "]";
	}

}
