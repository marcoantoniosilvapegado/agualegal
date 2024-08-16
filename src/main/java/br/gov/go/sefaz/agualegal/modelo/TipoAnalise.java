package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_TIPO_ANALISE")
public class TipoAnalise {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_analise")
	@SequenceGenerator(name = "seq_tipo_analise", sequenceName = "APL_AGUALEGAL.seq_tab_tipo_analise", allocationSize = 1)
	@Column(name = "id_tipo_analise")
	private Integer idTipoAnalise;

	@Column(name = "tipo_analise", nullable = false, length = 50, unique = true)
	private String tipoAnalise;

	@ManyToOne
	@JoinColumn(name = "id_status", nullable = false)
	private TipoStatus status;

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

	public TipoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoAnalise, status, tipoAnalise);
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
		return Objects.equals(idTipoAnalise, other.idTipoAnalise) && Objects.equals(status, other.status)
				&& Objects.equals(tipoAnalise, other.tipoAnalise);
	}

	@Override
	public String toString() {
		return "TipoAnalise [idTipoAnalise=" + idTipoAnalise + ", tipoAnalise=" + tipoAnalise + ", status=" + status
				+ "]";
	}

}
