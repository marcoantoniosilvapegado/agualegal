package br.gov.go.sefaz.agualegal.domain;

import java.util.Objects;

public class PreAnaliseResultado {

	private boolean deferido;

	private Integer idMotivoIndeferimento;

	public PreAnaliseResultado() {
		
	}

	public PreAnaliseResultado(boolean deferido) {
		super();
		this.deferido = deferido;
	}

	public PreAnaliseResultado(boolean deferido, Integer idMotivoIndeferimento) {
		super();
		this.deferido = deferido;
		this.idMotivoIndeferimento = idMotivoIndeferimento;
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

	@Override
	public String toString() {
		return "PreAnaliseResultado [deferido=" + deferido + ", idMotivoIndeferimento=" + idMotivoIndeferimento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deferido, idMotivoIndeferimento);
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
		return deferido == other.deferido && Objects.equals(idMotivoIndeferimento, other.idMotivoIndeferimento);
	}

}
