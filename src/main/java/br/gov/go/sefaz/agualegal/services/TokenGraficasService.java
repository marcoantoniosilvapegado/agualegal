package br.gov.go.sefaz.agualegal.services;

import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.enums.MENSAGENSPADRAO;
import br.gov.go.sefaz.agualegal.exception.TokenGraficaInvalidoException;

@Service
public class TokenGraficasService {
	
	public RespostaPadrao verificaTokenGrafica(String tokenGrafica) {
		
		/*Implementar lógica de validação do token da gráfica*/
		RespostaPadrao padraoResposta = new RespostaPadrao();
		if(tokenGrafica.equals("Bearer 123")) {
			throw new TokenGraficaInvalidoException(MENSAGENSPADRAO.GRAFICANAOENCONTRADA.getDesc(), 1);
		}else if(tokenGrafica.equals("Bearer 234")) {
			throw new TokenGraficaInvalidoException(MENSAGENSPADRAO.GRAFICANAOAUTORIZADA.getDesc(), 2);
		}else {
			padraoResposta = new RespostaPadrao(MENSAGENSPADRAO.GRAFICAENCONTRADA.getDesc(), 1, true);
		}
		
		return padraoResposta;
	}

}
