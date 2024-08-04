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
@Table(name = "TAB_STATUS_CREDENCIAMENTO")
public class StatusCredenciamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_credenciamento")
	@SequenceGenerator(name = "seq_status_credenciamento", sequenceName = "seq_tab_status_credenciamento", allocationSize = 1)
	@Column(name = "id_status_credenciamento")
	private Integer idStatusCredenciamento;

	@Column(name = "status_credenciamento", nullable = false, length = 50, unique = true)
	private String statusCredenciamento;

	public StatusCredenciamento() {
	
	}

	public Integer getIdStatusCredenciamento() {
		return idStatusCredenciamento;
	}

	public void setIdStatusCredenciamento(Integer idStatusCredenciamento) {
		this.idStatusCredenciamento = idStatusCredenciamento;
	}

	public String getStatusCredenciamento() {
		return statusCredenciamento;
	}

	public void setStatusCredenciamento(String statusCredenciamento) {
		this.statusCredenciamento = statusCredenciamento;
	}

	@Override
	public String toString() {
		return "StatusCredenciamento [idStatusCredenciamento=" + idStatusCredenciamento + ", statusCredenciamento="
				+ statusCredenciamento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStatusCredenciamento, statusCredenciamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusCredenciamento other = (StatusCredenciamento) obj;
		return Objects.equals(idStatusCredenciamento, other.idStatusCredenciamento)
				&& Objects.equals(statusCredenciamento, other.statusCredenciamento);
	}

}
