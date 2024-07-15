package br.gov.go.sefaz.agualegal.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
