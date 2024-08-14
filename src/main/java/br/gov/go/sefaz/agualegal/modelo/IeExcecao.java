package br.gov.go.sefaz.agualegal.modelo;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_IE_EXCECAO")
public class IeExcecao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ie_excecao")
	@SequenceGenerator(name = "seq_ie_excecao", sequenceName = "APL_AGUALEGAL.SEQ_TAB_IE_EXCECAO", allocationSize = 1)
	@Column(name = "ID_IE_EXCECAO", nullable = false)
	private Integer id;

	@Column(name = "INSCRICAO_ESTADUAL", nullable = false, length = 20)
	private String inscricaoEstadual;

	@Column(name = "RAZAO_SOCIAL", nullable = false, length = 200)
	private String razaoSocial;

	@Column(name = "DATA_INICIO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "DATA_FIM")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Column(name = "MOTIVO_EXCLUSAO", length = 200)
	private String motivoExclusao;

	public IeExcecao() {

	}

	public IeExcecao(Integer id, String inscricaoEstadual, String razaoSocial, Date dataInicio, Date dataFim,
			String motivoExclusao) {
		super();
		this.id = id;
		this.inscricaoEstadual = inscricaoEstadual;
		this.razaoSocial = razaoSocial;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.motivoExclusao = motivoExclusao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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

	public String getMotivoExclusao() {
		return motivoExclusao;
	}

	public void setMotivoExclusao(String motivoExclusao) {
		this.motivoExclusao = motivoExclusao;
	}

	@Override
	public String toString() {
		return "IeExcecao [id=" + id + ", inscricaoEstadual=" + inscricaoEstadual + ", razaoSocial=" + razaoSocial
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", motivoExclusao=" + motivoExclusao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFim, dataInicio, id, inscricaoEstadual, motivoExclusao, razaoSocial);
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
				&& Objects.equals(id, other.id) && Objects.equals(inscricaoEstadual, other.inscricaoEstadual)
				&& Objects.equals(motivoExclusao, other.motivoExclusao)
				&& Objects.equals(razaoSocial, other.razaoSocial);
	}

}
