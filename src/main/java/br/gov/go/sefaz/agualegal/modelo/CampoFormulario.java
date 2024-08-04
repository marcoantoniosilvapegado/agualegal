package br.gov.go.sefaz.agualegal.modelo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "TAB_CAMPO_FORMULARIO")
public class CampoFormulario {

	@Id
	@Column(name = "id_campo_formulario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_criterio", nullable = false, length = 100)
	private String nomeCriterio;

	@Column(name = "descricao_criterio", length = 220)
	private String descricaoCriterio;

	@ManyToOne
	@JoinColumn(name = "id_tipo_analise", nullable = false)
	private TipoAnalise tipoAnalise;

	@ManyToOne
	@JoinColumn(name = "id_tipo_resposta", nullable = false)
	private TipoResposta tipoResposta;

	@Column(name = "campo_obrigatorio", nullable = false, length = 1)
	private String campoObrigatorio;

	@Column(name = "tem_data_vencimento", nullable = false, length = 1)
	private String temDataVencimento;

	@Column(name = "data_vencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@Column(name = "disponibilizar_campo", nullable = false, length = 1)
	private String disponibilizarCampo;

	@Column(name = "status", nullable = false, length = 1)
	private String status;
	
	

	public CampoFormulario() {

	}

	public CampoFormulario(Long id, String nomeCriterio, String descricaoCriterio, TipoAnalise tipoAnalise,
			TipoResposta tipoResposta, String campoObrigatorio, String temDataVencimento, Date dataVencimento,
			String disponibilizarCampo, String status) {
		super();
		this.id = id;
		this.nomeCriterio = nomeCriterio;
		this.descricaoCriterio = descricaoCriterio;
		this.tipoAnalise = tipoAnalise;
		this.tipoResposta = tipoResposta;
		this.campoObrigatorio = campoObrigatorio;
		this.temDataVencimento = temDataVencimento;
		this.dataVencimento = dataVencimento;
		this.disponibilizarCampo = disponibilizarCampo;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCriterio() {
		return nomeCriterio;
	}

	public void setNomeCriterio(String nomeCriterio) {
		this.nomeCriterio = nomeCriterio;
	}

	public String getDescricaoCriterio() {
		return descricaoCriterio;
	}

	public void setDescricaoCriterio(String descricaoCriterio) {
		this.descricaoCriterio = descricaoCriterio;
	}

	public TipoAnalise getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(TipoAnalise tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	public TipoResposta getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(TipoResposta tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	public String getCampoObrigatorio() {
		return campoObrigatorio;
	}

	public void setCampoObrigatorio(String campoObrigatorio) {
		this.campoObrigatorio = campoObrigatorio;
	}

	public String getTemDataVencimento() {
		return temDataVencimento;
	}

	public void setTemDataVencimento(String temDataVencimento) {
		this.temDataVencimento = temDataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDisponibilizarCampo() {
		return disponibilizarCampo;
	}

	public void setDisponibilizarCampo(String disponibilizarCampo) {
		this.disponibilizarCampo = disponibilizarCampo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CampoFormulario [id=" + id + ", nomeCriterio=" + nomeCriterio + ", descricaoCriterio="
				+ descricaoCriterio + ", tipoAnalise=" + tipoAnalise + ", tipoResposta=" + tipoResposta
				+ ", campoObrigatorio=" + campoObrigatorio + ", temDataVencimento=" + temDataVencimento
				+ ", dataVencimento=" + dataVencimento + ", disponibilizarCampo=" + disponibilizarCampo + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(campoObrigatorio, dataVencimento, descricaoCriterio, disponibilizarCampo, id, nomeCriterio,
				status, temDataVencimento, tipoAnalise, tipoResposta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampoFormulario other = (CampoFormulario) obj;
		return Objects.equals(campoObrigatorio, other.campoObrigatorio)
				&& Objects.equals(dataVencimento, other.dataVencimento)
				&& Objects.equals(descricaoCriterio, other.descricaoCriterio)
				&& Objects.equals(disponibilizarCampo, other.disponibilizarCampo) && Objects.equals(id, other.id)
				&& Objects.equals(nomeCriterio, other.nomeCriterio) && Objects.equals(status, other.status)
				&& Objects.equals(temDataVencimento, other.temDataVencimento)
				&& Objects.equals(tipoAnalise, other.tipoAnalise) && Objects.equals(tipoResposta, other.tipoResposta);
	}

}
