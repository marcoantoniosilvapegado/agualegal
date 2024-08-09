package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAB_EMISSOR_LICENCA")
public class EmissorLicenca {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emissor_licenca")
	@SequenceGenerator(name = "seq_emissor_licenca", sequenceName = "seq_tab_emissor_licenca", allocationSize = 1)
	@Column(name = "id_emissor_licenca")
	private Integer idEmissorLicenca;

	@Column(name = "emissor_licenca", unique = true, nullable = false)
	private String emissorLicenca;

	public EmissorLicenca() {

	}

	public Integer getIdEmissorLicenca() {
		return idEmissorLicenca;
	}

	public void setIdEmissorLicenca(Integer idEmissorLicenca) {
		this.idEmissorLicenca = idEmissorLicenca;
	}

	public String getEmissorLicenca() {
		return emissorLicenca;
	}

	public void setEmissorLicenca(String emissorLicenca) {
		this.emissorLicenca = emissorLicenca;
	}

	@Override
	public String toString() {
		return "EmissorLicenca [idEmissorLicenca=" + idEmissorLicenca + ", emissorLicenca=" + emissorLicenca + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emissorLicenca, idEmissorLicenca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmissorLicenca other = (EmissorLicenca) obj;
		return Objects.equals(emissorLicenca, other.emissorLicenca)
				&& Objects.equals(idEmissorLicenca, other.idEmissorLicenca);
	}

}