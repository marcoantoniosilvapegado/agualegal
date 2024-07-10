package br.gov.go.sefaz.agualegal.domain;

import java.io.Serializable;
import java.util.Objects;

public class RespostaPadrao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descricao;
	private Integer codigo;
	private Boolean resultado;
	
	public RespostaPadrao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RespostaPadrao(String descricao, Integer codigo, Boolean resultado) {
		super();
		this.descricao = descricao;
		this.codigo = codigo;
		this.resultado = resultado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Boolean getResultado() {
		return resultado;
	}
	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return "RespostaPadrao [descricao=" + descricao + ", codigo=" + codigo + ", resultado=" + resultado + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricao, resultado);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaPadrao other = (RespostaPadrao) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(resultado, other.resultado);
	}
	
	
	
	
}
