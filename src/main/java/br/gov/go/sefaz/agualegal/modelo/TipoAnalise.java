package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_TIPO_ANALISE")
public class TipoAnalise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_analise")
	private Long id;

	@Column(name = "tipo_analise", nullable = false, length = 100)
	private String tipoAnalise;

	public TipoAnalise() {
		
	}

	public TipoAnalise(Long id, String tipoAnalise) {		
		this.id = id;
		this.tipoAnalise = tipoAnalise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(String tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	@Override
	public String toString() {
		return "TipoAnalise [id=" + id + ", tipoAnalise=" + tipoAnalise + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoAnalise);
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
		return Objects.equals(id, other.id) && Objects.equals(tipoAnalise, other.tipoAnalise);
	}

}
