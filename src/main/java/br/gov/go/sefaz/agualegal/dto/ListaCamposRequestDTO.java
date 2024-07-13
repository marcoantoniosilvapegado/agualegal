package br.gov.go.sefaz.agualegal.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ListaCamposRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "É obrigatório informar a inscrição estadual!")
	private String inscricaoEstadual;

	@NotEmpty(message = "É obrigatório informar o tipo da água!")
	@Pattern(regexp = "1|2|3", message = "O tipo da água deve ser 1(Adicionada de sais), 2(mineral) ou 3(ambas)!")
	private String tipoAgua;

	@NotEmpty(message = "É obrigatório informar o token!")
	private String tokenGrafica;
	
	public ListaCamposRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getTipoAgua() {
		return tipoAgua;
	}

	public void setTipoAgua(String tipoAgua) {
		this.tipoAgua = tipoAgua;
	}

	public String getTokenGrafica() {
		return tokenGrafica;
	}

	public void setTokenGrafica(String tokenGrafica) {
		this.tokenGrafica = tokenGrafica;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inscricaoEstadual, tipoAgua, tokenGrafica);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaCamposRequestDTO other = (ListaCamposRequestDTO) obj;
		return Objects.equals(inscricaoEstadual, other.inscricaoEstadual) && Objects.equals(tipoAgua, other.tipoAgua)
				&& Objects.equals(tokenGrafica, other.tokenGrafica);
	}

	@Override
	public String toString() {
		return "ListarCamposDTO [inscricaoEstadual=" + inscricaoEstadual + ", tipoAgua=" + tipoAgua + ", tokenGrafica="
				+ tokenGrafica + "]";
	}
	
	
}
