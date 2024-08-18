package br.gov.go.sefaz.agualegal.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class CampoDTO implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String campo;
	
	private String analise;
	
	private String obrigatorio;
	
	

	public CampoDTO() {
		
	}

	public CampoDTO(String campo, String analise, String obrigatorio) {
		super();
		this.campo = campo;
		this.analise = analise;
		this.obrigatorio = obrigatorio;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getAnalise() {
		return analise;
	}

	public void setAnalise(String analise) {
		this.analise = analise;
	}

	public String getObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(String obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	@Override
	public String toString() {
		return "CamposDTO [campo=" + campo + ", analise=" + analise + ", obrigatorio=" + obrigatorio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(analise, campo, obrigatorio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampoDTO other = (CampoDTO) obj;
		return Objects.equals(analise, other.analise) && Objects.equals(campo, other.campo)
				&& Objects.equals(obrigatorio, other.obrigatorio);
	}
	
	
	
}
