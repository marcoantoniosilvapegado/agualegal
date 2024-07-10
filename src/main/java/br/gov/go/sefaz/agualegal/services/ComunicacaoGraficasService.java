package br.gov.go.sefaz.agualegal.services;

import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.exception.TokenGraficaInvalidoException;

@Service
public class ComunicacaoGraficasService {

	private TokenGraficasService tokenGraficasService;

	public ComunicacaoGraficasService(TokenGraficasService tokenGraficasService) {
		this.tokenGraficasService = tokenGraficasService;
	}
	
	
	public void verificaSituacaoEnvasora(SituacaoEnvasadoraDTO dto) {
		
		/*Verifica se token da gráfica é válido*/
		 RespostaPadrao validaTokenGrafica = 
				 tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());
		 if(validaTokenGrafica.getResultado()) {
			 /*Token da gráfica é válido, seguir o fluxo do método*/
		 }
		 
		
		
		
		
	}
	
	
}
