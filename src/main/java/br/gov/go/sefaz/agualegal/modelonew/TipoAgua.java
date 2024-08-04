package br.gov.go.sefaz.agualegal.modelonew;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_TIPO_AGUA")
public class TipoAgua {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_agua")
	@SequenceGenerator(name = "seq_tipo_agua", sequenceName = "seq_tab_tipo_agua", allocationSize = 1)
	@Column(name = "id_tipo_agua")
	private Integer idTipoAgua;

	@Column(name = "tipo_agua", nullable = false, length = 50)
	private String tipoAgua;

	public TipoAgua() {
		
	}

	public Integer getIdTipoAgua() {
		return idTipoAgua;
	}

	public void setIdTipoAgua(Integer idTipoAgua) {
		this.idTipoAgua = idTipoAgua;
	}

	public String getTipoAgua() {
		return tipoAgua;
	}

	public void setTipoAgua(String tipoAgua) {
		this.tipoAgua = tipoAgua;
	}

	@Override
	public String toString() {
		return "TipoAgua [idTipoAgua=" + idTipoAgua + ", tipoAgua=" + tipoAgua + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoAgua, tipoAgua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAgua other = (TipoAgua) obj;
		return Objects.equals(idTipoAgua, other.idTipoAgua) && Objects.equals(tipoAgua, other.tipoAgua);
	}

}
