package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.util.Objects;

import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;

public class CampoPersistDTO {

	private String idCriterio;

	private String nomeCriterio;

	private String codigoCriterio;

	public CampoPersistDTO(CampoFormulario campoFormulario) {
		this.idCriterio = campoFormulario.getIdCampoFormulario().toString();
		this.nomeCriterio = campoFormulario.getNomeCriterio();
		this.codigoCriterio = campoFormulario.getCodigoCriterio();
	}

	public CampoPersistDTO() {

	}

	public CampoPersistDTO(String idCriterio, String nomeCriterio, String codigoCriterio) {
		super();
		this.idCriterio = idCriterio;
		this.nomeCriterio = nomeCriterio;
		this.codigoCriterio = codigoCriterio;
	}

	public String getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(String idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getNomeCriterio() {
		return nomeCriterio;
	}

	public void setNomeCriterio(String nomeCriterio) {
		this.nomeCriterio = nomeCriterio;
	}

	public String getCodigoCriterio() {
		return codigoCriterio;
	}

	public void setCodigoCriterio(String codigoCriterio) {
		this.codigoCriterio = codigoCriterio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCriterio, idCriterio, nomeCriterio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampoPersistDTO other = (CampoPersistDTO) obj;
		return Objects.equals(codigoCriterio, other.codigoCriterio) && Objects.equals(idCriterio, other.idCriterio)
				&& Objects.equals(nomeCriterio, other.nomeCriterio);
	}

	@Override
	public String toString() {
		return "CampoPersistDTO [idCriterio=" + idCriterio + ", nomeCriterio=" + nomeCriterio + ", codigoCriterio="
				+ codigoCriterio + "]";
	}

}
