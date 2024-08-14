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
@Table(schema = "APL_AGUALEGAL", name = "TAB_STATUS_ANALISE")
public class StatusAnalise {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_analise")
	@SequenceGenerator(name = "seq_status_analise", sequenceName = "APL_AGUALEGAL.seq_tab_status_analise", allocationSize = 1)
	@Column(name = "id_status_analise")
	private Integer idStatusAnalise;

	@Column(name = "status_analise", nullable = false, length = 50, unique = true)
	private String descricaoStatus;

	public StatusAnalise() {

	}

	public Integer getIdStatusAnalise() {
		return idStatusAnalise;
	}

	public void setIdStatusAnalise(Integer idStatusAnalise) {
		this.idStatusAnalise = idStatusAnalise;
	}

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	@Override
	public String toString() {
		return "StatusAnalise [idStatusAnalise=" + idStatusAnalise + ", descricaoStatus=" + descricaoStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoStatus, idStatusAnalise);
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
		return Objects.equals(descricaoStatus, other.descricaoStatus)
				&& Objects.equals(idStatusAnalise, other.idStatusAnalise);
	}

}