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
@Table(name = "TAB_TIPO_LICENCA")
public class TipoLicenca {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_licenca")
	@SequenceGenerator(name = "seq_tipo_licenca", sequenceName = "seq_tab_tipo_licenca", allocationSize = 1)
	@Column(name = "id_tipo_licenca")
	private Integer idTipoLicenca;

	@Column(name = "tipo_licenca", nullable = false, length = 50, unique = true)
	private String tipoLicenca;

	public TipoLicenca() {
	
	}

	public Integer getIdTipoLicenca() {
		return idTipoLicenca;
	}

	public void setIdTipoLicenca(Integer idTipoLicenca) {
		this.idTipoLicenca = idTipoLicenca;
	}

	public String getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(String tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

	@Override
	public String toString() {
		return "TipoLicenca [idTipoLicenca=" + idTipoLicenca + ", tipoLicenca=" + tipoLicenca + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoLicenca, tipoLicenca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoLicenca other = (TipoLicenca) obj;
		return Objects.equals(idTipoLicenca, other.idTipoLicenca) && Objects.equals(tipoLicenca, other.tipoLicenca);
	}

}
