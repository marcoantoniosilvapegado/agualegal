package br.gov.go.sefaz.agualegal.modelo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "TAB_IE_EXCECAO")
public class IeExcecao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ie_excecao")
	private Long id;

	@Column(name = "ie", nullable = false)
	private Long ie;

	@Column(name = "nome_envasadora", nullable = false, length = 100)
	private String nomeEnvasadora;

	@Column(name = "motivo", length = 200)
	private String motivo;

	@Column(name = "data_inicio", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	public IeExcecao() {
		
	}

	public IeExcecao(Long id, Long ie, String nomeEnvasadora, String motivo, Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.ie = ie;
		this.nomeEnvasadora = nomeEnvasadora;
		this.motivo = motivo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIe() {
		return ie;
	}

	public void setIe(Long ie) {
		this.ie = ie;
	}

	public String getNomeEnvasadora() {
		return nomeEnvasadora;
	}

	public void setNomeEnvasadora(String nomeEnvasadora) {
		this.nomeEnvasadora = nomeEnvasadora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFim, dataInicio, id, ie, motivo, nomeEnvasadora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IeExcecao other = (IeExcecao) obj;
		return Objects.equals(dataFim, other.dataFim) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(id, other.id) && Objects.equals(ie, other.ie) && Objects.equals(motivo, other.motivo)
				&& Objects.equals(nomeEnvasadora, other.nomeEnvasadora);
	}

	@Override
	public String toString() {
		return "IeExcecao [id=" + id + ", ie=" + ie + ", nomeEnvasadora=" + nomeEnvasadora + ", motivo=" + motivo
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}

}
