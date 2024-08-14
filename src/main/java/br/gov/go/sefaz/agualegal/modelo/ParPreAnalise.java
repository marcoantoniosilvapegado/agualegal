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
@Table(schema = "APL_AGUALEGAL", name = "TAB_PAR_PRE_ANALISE")
public class ParPreAnalise {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_par_pre_analise")
	@SequenceGenerator(name = "seq_par_pre_analise", sequenceName = "APL_AGUALEGAL.SEQ_TAB_PAR_PRE_ANALISE", allocationSize = 1)
	@Column(name = "ID_PAR_PRE_ANALISE", nullable = false)
	private Integer id;

	@Column(name = "SITUACAO_FISC_ATIVA", nullable = false, length = 1)
	private String situacaoFiscAtiva;

	@Column(name = "POSSUI_CNAE", nullable = false, length = 1)
	private String possuiCnae;

	@Column(name = "EXISTE_SOLICITANTE", nullable = false, length = 1)
	private String existeSolicitante;

	@Column(name = "CNAE_ENVASE", nullable = false, length = 7)
	private String cnaeEnvase;

	public ParPreAnalise() {
		// TODO Auto-generated constructor stub
	}

	public ParPreAnalise(Integer id, String situacaoFiscAtiva, String possuiCnae, String existeSolicitante,
			String cnaeEnvase) {
		super();
		this.id = id;
		this.situacaoFiscAtiva = situacaoFiscAtiva;
		this.possuiCnae = possuiCnae;
		this.existeSolicitante = existeSolicitante;
		this.cnaeEnvase = cnaeEnvase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSituacaoFiscAtiva() {
		return situacaoFiscAtiva;
	}

	public void setSituacaoFiscAtiva(String situacaoFiscAtiva) {
		this.situacaoFiscAtiva = situacaoFiscAtiva;
	}

	public String getPossuiCnae() {
		return possuiCnae;
	}

	public void setPossuiCnae(String possuiCnae) {
		this.possuiCnae = possuiCnae;
	}

	public String getExisteSolicitante() {
		return existeSolicitante;
	}

	public void setExisteSolicitante(String existeSolicitante) {
		this.existeSolicitante = existeSolicitante;
	}

	public String getCnaeEnvase() {
		return cnaeEnvase;
	}

	public void setCnaeEnvase(String cnaeEnvase) {
		this.cnaeEnvase = cnaeEnvase;
	}

	@Override
	public String toString() {
		return "ParPreAnalise [id=" + id + ", situacaoFiscAtiva=" + situacaoFiscAtiva + ", possuiCnae=" + possuiCnae
				+ ", existeSolicitante=" + existeSolicitante + ", cnaeEnvase=" + cnaeEnvase + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnaeEnvase, existeSolicitante, id, possuiCnae, situacaoFiscAtiva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParPreAnalise other = (ParPreAnalise) obj;
		return Objects.equals(cnaeEnvase, other.cnaeEnvase)
				&& Objects.equals(existeSolicitante, other.existeSolicitante) && Objects.equals(id, other.id)
				&& Objects.equals(possuiCnae, other.possuiCnae)
				&& Objects.equals(situacaoFiscAtiva, other.situacaoFiscAtiva);
	}

}
