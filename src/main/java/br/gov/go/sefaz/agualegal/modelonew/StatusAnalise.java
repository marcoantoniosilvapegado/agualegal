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
@Table(name = "TAB_STATUS_ANALISE")
public class StatusAnalise {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_analise")
	@SequenceGenerator(name = "seq_status_analise", sequenceName = "seq_tab_status_analise", allocationSize = 1)
	@Column(name = "id_status_analise")
	private Integer idStatusAnalise;

	@Column(name = "status_analise", nullable = false, length = 50, unique = true)
	private String statusAnalise;

	public StatusAnalise() {

	}

	public Integer getIdStatusAnalise() {
		return idStatusAnalise;
	}

	public void setIdStatusAnalise(Integer idStatusAnalise) {
		this.idStatusAnalise = idStatusAnalise;
	}

	public String getStatusAnalise() {
		return statusAnalise;
	}

	public void setStatusAnalise(String statusAnalise) {
		this.statusAnalise = statusAnalise;
	}

	@Override
	public String toString() {
		return "StatusAnalise [idStatusAnalise=" + idStatusAnalise + ", statusAnalise=" + statusAnalise + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStatusAnalise, statusAnalise);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusAnalise other = (StatusAnalise) obj;
		return Objects.equals(idStatusAnalise, other.idStatusAnalise)
				&& Objects.equals(statusAnalise, other.statusAnalise);
	}

}