package br.gov.go.sefaz.agualegal.modelonew;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CAMPOS_FORMULARIO")
public class CampoFormulario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_campos_formulario")
	@SequenceGenerator(name = "seq_campos_formulario", sequenceName = "seq_tab_campos_formulario", allocationSize = 1)
	@Column(name = "id_campo_formulario", nullable = false)
	private Long idCampoFormulario;

	@Column(name = "nome_criterio", unique = true, length = 100)
	private String nomeCriterio;

	@Column(name = "descricao_criterio", length = 200)
	private String descricaoCriterio;

	@Column(name = "codigo_criterio", unique = true, length = 30)
	private String codigoCriterio;

	@Column(name = "campo_obrigatorio", length = 1)
	private char campoObrigatorio;

	@Column(name = "disponilizar_campo", length = 1)
	private char disponibilizarCampo;

	@Column(name = "status", length = 1)
	private char status;

	@ManyToOne
	@JoinColumn(name = "id_tipo_analise", foreignKey = @ForeignKey(name = "FK_TIPO_ANALISE"))
	private TipoAnalise tipoAnalise;

	@ManyToOne
	@JoinColumn(name = "id_tipo_resposta", foreignKey = @ForeignKey(name = "FK_TIPO_RESPOSTA"))
	private TipoResposta tipoResposta;

	public CampoFormulario() {
		
	}

	public CampoFormulario(Long idCampoFormulario, String nomeCriterio, String descricaoCriterio,
			String codigoCriterio, char campoObrigatorio, char disponibilizarCampo, char status,
			TipoAnalise tipoAnalise, TipoResposta tipoResposta) {		
		this.idCampoFormulario = idCampoFormulario;
		this.nomeCriterio = nomeCriterio;
		this.descricaoCriterio = descricaoCriterio;
		this.codigoCriterio = codigoCriterio;
		this.campoObrigatorio = campoObrigatorio;
		this.disponibilizarCampo = disponibilizarCampo;
		this.status = status;
		this.tipoAnalise = tipoAnalise;
		this.tipoResposta = tipoResposta;
	}

	public Long getIdCampoFormulario() {
		return idCampoFormulario;
	}

	public void setIdCampoFormulario(Long idCampoFormulario) {
		this.idCampoFormulario = idCampoFormulario;
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

	public String getCodigoCriterio() {
		return codigoCriterio;
	}

	public void setCodigoCriterio(String codigoCriterio) {
		this.codigoCriterio = codigoCriterio;
	}

	public char getCampoObrigatorio() {
		return campoObrigatorio;
	}

	public void setCampoObrigatorio(char campoObrigatorio) {
		this.campoObrigatorio = campoObrigatorio;
	}

	public char getDisponibilizarCampo() {
		return disponibilizarCampo;
	}

	public void setDisponibilizarCampo(char disponibilizarCampo) {
		this.disponibilizarCampo = disponibilizarCampo;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "CamposFormulario [idCampoFormulario=" + idCampoFormulario + ", nomeCriterio=" + nomeCriterio
				+ ", descricaoCriterio=" + descricaoCriterio + ", codigoCriterio=" + codigoCriterio
				+ ", campoObrigatorio=" + campoObrigatorio + ", disponibilizarCampo=" + disponibilizarCampo
				+ ", status=" + status + ", tipoAnalise=" + tipoAnalise + ", tipoResposta=" + tipoResposta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(campoObrigatorio, codigoCriterio, descricaoCriterio, disponibilizarCampo, idCampoFormulario,
				nomeCriterio, status, tipoAnalise, tipoResposta);
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
		return campoObrigatorio == other.campoObrigatorio && Objects.equals(codigoCriterio, other.codigoCriterio)
				&& Objects.equals(descricaoCriterio, other.descricaoCriterio)
				&& disponibilizarCampo == other.disponibilizarCampo
				&& Objects.equals(idCampoFormulario, other.idCampoFormulario)
				&& Objects.equals(nomeCriterio, other.nomeCriterio) && status == other.status
				&& Objects.equals(tipoAnalise, other.tipoAnalise) && Objects.equals(tipoResposta, other.tipoResposta);
	}

}
