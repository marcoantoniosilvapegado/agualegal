package br.gov.go.sefaz.agualegal.modelo;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CREDENCIAMENTO")
public class Credenciamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_credenciamento")
	@SequenceGenerator(name = "seq_credenciamento", sequenceName = "seq_tab_credenciamento", allocationSize = 1)
	@Column(name = "id_credenciamento")
	private Integer idCredenciamento;

	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@Column(name = "data_fim")
	private LocalDate dataFim;

	@ManyToOne
	@JoinColumn(name = "id_status_credenciamento", nullable = false)
	private StatusCredenciamento statusCredenciamento;

	@ManyToOne
	@JoinColumn(name = "id_envasadora", nullable = false)
	private Envasadora envasadora;

	public Credenciamento() {
		
	}

	public Integer getIdCredenciamento() {
		return idCredenciamento;
	}

	public void setIdCredenciamento(Integer idCredenciamento) {
		this.idCredenciamento = idCredenciamento;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public StatusCredenciamento getStatusCredenciamento() {
		return statusCredenciamento;
	}

	public void setStatusCredenciamento(StatusCredenciamento statusCredenciamento) {
		this.statusCredenciamento = statusCredenciamento;
	}

	public Envasadora getEnvasadora() {
		return envasadora;
	}

	public void setEnvasadora(Envasadora envasadora) {
		this.envasadora = envasadora;
	}

	@Override
	public String toString() {
		return "Credenciamento [idCredenciamento=" + idCredenciamento + ", dataInicio=" + dataInicio + ", dataFim="
				+ dataFim + ", statusCredenciamento=" + statusCredenciamento + ", envasadora=" + envasadora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFim, dataInicio, envasadora, idCredenciamento, statusCredenciamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credenciamento other = (Credenciamento) obj;
		return Objects.equals(dataFim, other.dataFim) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(envasadora, other.envasadora)
				&& Objects.equals(idCredenciamento, other.idCredenciamento)
				&& Objects.equals(statusCredenciamento, other.statusCredenciamento);
	}

}
