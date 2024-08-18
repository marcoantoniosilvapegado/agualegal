package br.gov.go.sefaz.agualegal.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.modelo.Grafica;
import br.gov.go.sefaz.agualegal.repository.GraficaRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class ValidaTokenGraficaService {
	
	private GraficaRepository graficaRepository;

	public ValidaTokenGraficaService(GraficaRepository graficaRepository) {	
		this.graficaRepository = graficaRepository;
	}

	public boolean validaTokenGrafica(String cnpjGrafica, String token){
		String tokenConvertidoMDS = UtilsAguaLegal.converteSHA256(token);
		Optional<Grafica> validaTokenGrafica = this.graficaRepository.findByTokenAndCnpj(tokenConvertidoMDS,
				cnpjGrafica);
		return validaTokenGrafica.isPresent();
	}
}
