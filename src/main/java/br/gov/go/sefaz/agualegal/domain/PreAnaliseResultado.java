package br.gov.go.sefaz.agualegal.domain;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PreAnaliseResultado {

	private boolean deferido;

	private Integer idMotivoIndeferimento;

	private Long situacaoFiscalSefaz;

	public PreAnaliseResultado() {

	}

	public PreAnaliseResultado(boolean deferido) {
		super();
		this.deferido = deferido;
	}

	public PreAnaliseResultado(boolean deferido, Long situacaoFiscalSefaz) {
		super();
		this.deferido = deferido;
		this.situacaoFiscalSefaz = situacaoFiscalSefaz;
	}

	public PreAnaliseResultado(boolean deferido, Integer idMotivoIndeferimento) {
		super();
		this.deferido = deferido;
		this.idMotivoIndeferimento = idMotivoIndeferimento;
	}

	public PreAnaliseResultado(boolean deferido, Integer idMotivoIndeferimento, Long situacaoFiscalSefaz) {
		super();
		this.deferido = deferido;
		this.idMotivoIndeferimento = idMotivoIndeferimento;
		this.situacaoFiscalSefaz = situacaoFiscalSefaz;
	}

	public boolean isDeferido() {
		return deferido;
	}

	public void setDeferido(boolean deferido) {
		this.deferido = deferido;
	}

	public Integer getIdMotivoIndeferimento() {
		return idMotivoIndeferimento;
	}

	public void setIdMotivoIndeferimento(Integer idMotivoIndeferimento) {
		this.idMotivoIndeferimento = idMotivoIndeferimento;
	}

	public Long getSituacaoFiscalSefaz() {
		return situacaoFiscalSefaz;
	}

	public void setSituacaoFiscalSefaz(Long situacaoFiscalSefaz) {
		this.situacaoFiscalSefaz = situacaoFiscalSefaz;
	}

	@Override
	public String toString() {
		return "PreAnaliseResultado [deferido=" + deferido + ", idMotivoIndeferimento=" + idMotivoIndeferimento
				+ ", situacaoFiscalSefaz=" + situacaoFiscalSefaz + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deferido, idMotivoIndeferimento, situacaoFiscalSefaz);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreAnaliseResultado other = (PreAnaliseResultado) obj;
		return deferido == other.deferido && Objects.equals(idMotivoIndeferimento, other.idMotivoIndeferimento)
				&& Objects.equals(situacaoFiscalSefaz, other.situacaoFiscalSefaz);
	}

}
