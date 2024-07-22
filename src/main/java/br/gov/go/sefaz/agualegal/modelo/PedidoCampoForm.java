package br.gov.go.sefaz.agualegal.modelo;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.go.sefaz.agualegal.dto.solicitacao.CampoDTO;

@Entity
@Table(name = "TAB_PEDIDO_CAMPO_FORM")
public class PedidoCampoForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_campo_form")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_pedido_credenciamento", nullable = false)
	private PedidoCredenciamento pedidoCredenciamento;

	@Column(name = "valor_campo", length = 200)
	private String valorCampo;

	@Lob
	@Column(name = "conteudo_arquivo")
	private byte[] conteudoArquivo;

	@ManyToOne
	@JoinColumn(name = "id_campo_formulario", nullable = false)
	private CampoFormulario campoFormulario;

	@Column(name = "data_vencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	public PedidoCampoForm() {

	}

	public PedidoCampoForm(Long id, PedidoCredenciamento pedidoCredenciamento, String valorCampo,
			byte[] conteudoArquivo, CampoFormulario campoFormulario) {
		super();
		this.id = id;
		this.pedidoCredenciamento = pedidoCredenciamento;
		this.valorCampo = valorCampo;
		this.conteudoArquivo = conteudoArquivo;
		this.campoFormulario = campoFormulario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PedidoCredenciamento getPedidoCredenciamento() {
		return pedidoCredenciamento;
	}

	public void setPedidoCredenciamento(PedidoCredenciamento pedidoCredenciamento) {
		this.pedidoCredenciamento = pedidoCredenciamento;
	}

	public String getValorCampo() {
		return valorCampo;
	}

	public void setValorCampo(String valorCampo) {
		this.valorCampo = valorCampo;
	}

	public byte[] getConteudoArquivo() {
		return conteudoArquivo;
	}

	public void setConteudoArquivo(byte[] conteudoArquivo) {
		this.conteudoArquivo = conteudoArquivo;
	}

	public CampoFormulario getCampoFormulario() {
		return campoFormulario;
	}

	public void setCampoFormulario(CampoFormulario campoFormulario) {
		this.campoFormulario = campoFormulario;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public String toString() {
		return "PedidoCampoForm [id=" + id + ", pedidoCredenciamento=" + pedidoCredenciamento + ", valorCampo="
				+ valorCampo + ", conteudoArquivo=" + Arrays.toString(conteudoArquivo) + ", campoFormulario="
				+ campoFormulario + ", dataVencimento=" + dataVencimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(conteudoArquivo);
		result = prime * result + Objects.hash(campoFormulario, dataVencimento, id, pedidoCredenciamento, valorCampo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoCampoForm other = (PedidoCampoForm) obj;
		return Objects.equals(campoFormulario, other.campoFormulario)
				&& Arrays.equals(conteudoArquivo, other.conteudoArquivo)
				&& Objects.equals(dataVencimento, other.dataVencimento) && Objects.equals(id, other.id)
				&& Objects.equals(pedidoCredenciamento, other.pedidoCredenciamento)
				&& Objects.equals(valorCampo, other.valorCampo);
	}

}
