package br.gov.go.sefaz.agualegal.dto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class SituacaoEnvasadoraDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "É obrigatório informar a inscrição estadual!")
	private String inscricaoEstadual;
	
	@NotBlank(message = "É obrigatório informar o token!")
	private String tokenGrafica;

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}	

	public String getTokenGrafica() {
		return tokenGrafica;
	}

	public void setTokenGrafica(String tokenGrafica) {
		this.tokenGrafica = tokenGrafica;
	}

	public SituacaoEnvasadoraDTO(String inscricaoEstadual, String tipoAgua, String tokenGrafica) {
		super();
		this.inscricaoEstadual = inscricaoEstadual;
		//this.tipoAgua = tipoAgua;
		this.tokenGrafica = tokenGrafica;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inscricaoEstadual, tokenGrafica);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SituacaoEnvasadoraDTO other = (SituacaoEnvasadoraDTO) obj;
		return Objects.equals(inscricaoEstadual, other.inscricaoEstadual) 
				&& Objects.equals(tokenGrafica, other.tokenGrafica);
	}

	@Override
	public String toString() {
		return "SituacaoEnvasadoraDTO [inscricaoEstadual=" + inscricaoEstadual 
				+ ", tokenGrafica=" + tokenGrafica + "]";
	}
	
}
