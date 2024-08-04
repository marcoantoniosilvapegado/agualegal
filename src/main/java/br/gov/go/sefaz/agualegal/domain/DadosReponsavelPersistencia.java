package br.gov.go.sefaz.agualegal.domain;

import java.util.Objects;

import br.gov.go.sefaz.agualegal.dto.solicitacao.ResponsavelDTO;

public class DadosReponsavelPersistencia {

	private String idEnvasadora;

	private ResponsavelDTO responsavelDTO;

	public String getIdEnvasadora() {
		return idEnvasadora;
	}

	public void setIdEnvasadora(String idEnvasadora) {
		this.idEnvasadora = idEnvasadora;
	}

	public ResponsavelDTO getResponsavelDTO() {
		return responsavelDTO;
	}

	public void setResponsavelDTO(ResponsavelDTO responsavelDTO) {
		this.responsavelDTO = responsavelDTO;
	}

	public DadosReponsavelPersistencia() {
		// TODO Auto-generated constructor stub
	}

	public DadosReponsavelPersistencia(ResponsavelDTO responsavelDTO, String idEnvasadora) {
		super();
		this.idEnvasadora = idEnvasadora;
		this.responsavelDTO = responsavelDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEnvasadora, responsavelDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosReponsavelPersistencia other = (DadosReponsavelPersistencia) obj;
		return Objects.equals(idEnvasadora, other.idEnvasadora) && Objects.equals(responsavelDTO, other.responsavelDTO);
	}

	@Override
	public String toString() {
		return "DadosReponsavelPersistencia [idEnvasadora=" + idEnvasadora + ", responsavelDTO=" + responsavelDTO + "]";
	}

}
