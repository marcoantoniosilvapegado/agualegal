package br.gov.go.sefaz.agualegal.dto;

import javax.validation.constraints.NotNull;

public class TokenRequestDTO {
	
	@NotNull(message = "É obrigatório informar o token!")
	private String tokenGrafica;

    public String getTokenGrafica() {
        return tokenGrafica;
    }

    public void setTokenGrafica(String tokenGrafica) {
        this.tokenGrafica = tokenGrafica;
    }
}
