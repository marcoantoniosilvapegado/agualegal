package br.gov.go.sefaz.agualegal.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.go.sefaz.agualegal.controller.docs.ComunicacaoGraficasControllerDocumentable;
import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.ListaCamposRequestDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposResponseDTO;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.dto.TokenRequestDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.services.ComunicacaoGraficasService;
import br.gov.go.sefaz.agualegal.services.TokenGraficasService;

//@RestController
//@RequestMapping(value = "/api")
public class ComunicacaoGraficasController 
//implements ComunicacaoGraficasControllerDocumentable 
{

	/*private ComunicacaoGraficasService comunicacaoGraficasService;
	
	private TokenGraficasService tokenGraficasService;

	public ComunicacaoGraficasController(
			TokenGraficasService tokenGraficasService,
			ComunicacaoGraficasService comunicacaoGraficasService) {
		super();
		this.tokenGraficasService = tokenGraficasService;
		this.comunicacaoGraficasService = comunicacaoGraficasService;
	}

	@PostMapping(value = "/situacaoGrafica", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespostaPadrao> consultaSituacaoGrafica(@RequestBody @Valid TokenRequestDTO dto) {

		RespostaPadrao resposta = this.tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@PostMapping(value = "/situacaoEnvasadora", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespostaPadrao> consultaSituacaoEnvasadora(@RequestBody @Valid SituacaoEnvasadoraDTO dto) {

		RespostaPadrao resposta = this.comunicacaoGraficasService.verificaSituacaoEnvasora(dto);
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@PostMapping(value = "/listarCampos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaCamposResponseDTO> listarCamposEnvasadora(
			@RequestBody @Valid ListaCamposRequestDTO dto) {

		ListaCamposResponseDTO resposta = this.comunicacaoGraficasService.listaCamposEnvasadora(dto);

		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@PostMapping(value = "/solicitarCredenciamento")
	public ResponseEntity<RespostaPadrao> solicitarCredenciamentoEnvasadora(
			@RequestBody @Valid DadosSolicitacaoDTO dto
			) {	
		RespostaPadrao resposta = this.comunicacaoGraficasService.solicitaCredenciamentoEnvasadora(dto);
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}	*/

	
}