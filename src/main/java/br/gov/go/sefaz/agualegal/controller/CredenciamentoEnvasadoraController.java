package br.gov.go.sefaz.agualegal.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.services.CredenciamentoEnvasadoraService;

@RestController
@RequestMapping(value = "/api/credenciamento")
public class CredenciamentoEnvasadoraController {

	private CredenciamentoEnvasadoraService service;

	public CredenciamentoEnvasadoraController(CredenciamentoEnvasadoraService service) {		
		this.service = service;
	}
	
	@PostMapping(value = "/solicitacao")
	public ResponseEntity<RespostaPadrao> solicitarCredenciamentoEnvasadora(
			@RequestBody @Valid DadosSolicitacaoDTO dto){			
		RespostaPadrao resposta = this.service.solicitaCredenciamentoEnvasadora(dto);
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}	
	

}
