package br.gov.go.sefaz.agualegal.services;

import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.enums.MENSAGENSPADRAO;
import br.gov.go.sefaz.agualegal.exception.EnvasadoraRegrasException;
import br.gov.go.sefaz.agualegal.exception.TokenGraficaInvalidoException;

@Service
public class ComunicacaoGraficasService {

	private TokenGraficasService tokenGraficasService;

	public ComunicacaoGraficasService(TokenGraficasService tokenGraficasService) {
		this.tokenGraficasService = tokenGraficasService;
	}
	
	
	public RespostaPadrao verificaSituacaoEnvasora(SituacaoEnvasadoraDTO dto) {
		
		/*Verifica se token da gráfica é válido*/
		 RespostaPadrao validaTokenGrafica = 
				 tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());
		
			 /*Token da gráfica é válido, seguir o fluxo do método*/
			 if(dto.getInscricaoEstadual().equals("123")) {
				 throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORANAOEXISTE.getDesc(), 2);
			 }
			 if(dto.getInscricaoEstadual().equals("234")) {
				 throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORASITFISCINATIVA.getDesc(), 3);
			 }
			 if(dto.getInscricaoEstadual().equals("345")) {
				 return new RespostaPadrao(MENSAGENSPADRAO.ENVASADORAEXCECAO.getDesc(),
						 1, true);
			 }
			 return new RespostaPadrao(MENSAGENSPADRAO.ENVASADORAAUTORIZADA.getDesc(),
					 1, true);
			 
		// }
		 
		
		
		
		
	}
	
	
}
