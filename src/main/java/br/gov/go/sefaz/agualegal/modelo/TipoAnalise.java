package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_TIPO_ANALISE")
public class TipoAnalise {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_analise")
	@SequenceGenerator(name = "seq_tipo_analise", sequenceName = "seq_tab_tipo_analise", allocationSize = 1)
	@Column(name = "id_tipo_analise")
	private Integer idTipoAnalise;

	@Column(name = "tipo_analise", nullable = false, length = 50, unique = true)
	private String tipoAnalise;

	public TipoAnalise() {

	}

	public Integer getIdTipoAnalise() {
		return idTipoAnalise;
	}

	public void setIdTipoAnalise(Integer idTipoAnalise) {
		this.idTipoAnalise = idTipoAnalise;
	}

	public String getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(String tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	@Override
	public String toString() {
		return "TipoAnalise [idTipoAnalise=" + idTipoAnalise + ", tipoAnalise=" + tipoAnalise + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoAnalise, tipoAnalise);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAnalise other = (TipoAnalise) obj;
		return Objects.equals(idTipoAnalise, other.idTipoAnalise) && Objects.equals(tipoAnalise, other.tipoAnalise);
	}

}
