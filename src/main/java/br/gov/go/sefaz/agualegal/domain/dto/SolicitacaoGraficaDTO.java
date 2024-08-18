package br.gov.go.sefaz.agualegal.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class SolicitacaoGraficaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message =  "Favor informar o token da gráfica!")
	private String token;

	@NotBlank(message =  "Favor informar o CNPJ da gráfica!")
	private String cnpjGrafica;

	public SolicitacaoGraficaDTO() {

	}

	public SolicitacaoGraficaDTO(String token, String cnpjGrafica) {
		this.token = token;
		this.cnpjGrafica = cnpjGrafica;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCnpjGrafica() {
		return cnpjGrafica;
	}

	public void setCnpjGrafica(String cnpjGrafica) {
		this.cnpjGrafica = cnpjGrafica;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpjGrafica, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolicitacaoGraficaDTO other = (SolicitacaoGraficaDTO) obj;
		return Objects.equals(cnpjGrafica, other.cnpjGrafica) && Objects.equals(token, other.token);
	}

	@Override
	public String toString() {
		return "SolicitacaoGraficaDTO [token=" + token + ", cnpjGrafica=" + cnpjGrafica + "]";
	}

}
