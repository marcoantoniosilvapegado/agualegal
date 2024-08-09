package br.gov.go.sefaz.agualegal.controller;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.go.sefaz.agualegal.controller.docs.CredenciamentoEnvasadoraControllerDocumentable;
import br.gov.go.sefaz.agualegal.domain.RespostaPreAnalise;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.services.CredenciamentoEnvasadoraService;

@RestController
@RequestMapping(value = "/credenciamento")
public class CredenciamentoEnvasadoraController implements CredenciamentoEnvasadoraControllerDocumentable
{

	private CredenciamentoEnvasadoraService service;

	public CredenciamentoEnvasadoraController(CredenciamentoEnvasadoraService service) {
		this.service = service;
	}

	/*Endpoint responsável por receber a solicitação de credenciamento*/
	@PostMapping(value = "/solicitacao")
	public ResponseEntity<RespostaPreAnalise> solicitarCredenciamentoEnvasadora(
			@RequestBody @Valid DadosSolicitacaoDTO dto
			) {
		ResponseEntity<RespostaPreAnalise> 
					resposta = this.service.solicitaCredenciamentoEnvasadora(dto);		
		return  resposta;
	}	
}
