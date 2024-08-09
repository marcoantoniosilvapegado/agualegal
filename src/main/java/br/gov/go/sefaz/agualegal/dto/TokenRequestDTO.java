package br.gov.go.sefaz.agualegal.dto;

import jakarta.validation.constraints.NotBlank;

public class TokenRequestDTO {
	
	@NotBlank(message = "É obrigatório informar o token!")
	private String tokenGrafica;

    public String getTokenGrafica() {
        return tokenGrafica;
    }

    public void setTokenGrafica(String tokenGrafica) {
        this.tokenGrafica = tokenGrafica;
    }
}
