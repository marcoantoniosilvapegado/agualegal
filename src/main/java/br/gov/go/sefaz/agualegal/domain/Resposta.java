package br.gov.go.sefaz.agualegal.domain;

import java.io.Serializable;
import java.util.Objects;

public class Resposta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descricao;
	private Boolean resultado;

	public Resposta() {
		// TODO Auto-generated constructor stub
	}

	public Resposta(String descricao, Boolean resultado) {
		super();
		this.descricao = descricao;
		this.resultado = resultado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Resposta [descricao=" + descricao + ", resultado=" + resultado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, resultado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(resultado, other.resultado);
	}

}
