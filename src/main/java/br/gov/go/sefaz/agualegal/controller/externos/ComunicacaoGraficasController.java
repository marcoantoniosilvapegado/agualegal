package br.gov.go.sefaz.agualegal.controller.externos;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.go.sefaz.agualegal.controller.externos.docs.ComunicacaoGraficasControllerDocumentable;
import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.dto.TokenRequestDTO;
import br.gov.go.sefaz.agualegal.services.ComunicacaoGraficasService;
import br.gov.go.sefaz.agualegal.services.TokenGraficasService;

@RestController
@RequestMapping(value = "/api")
public class ComunicacaoGraficasController implements ComunicacaoGraficasControllerDocumentable {

	private ComunicacaoGraficasService comunicacaoGraficasService;
	private TokenGraficasService tokenGraficasService;

	public ComunicacaoGraficasController(ComunicacaoGraficasService comunicacaoGraficasService,
			TokenGraficasService tokenGraficasService) {
		super();
		this.comunicacaoGraficasService = comunicacaoGraficasService;
		this.tokenGraficasService = tokenGraficasService;
	}

	@PostMapping(value = "/situacaoEnvasadora")
	public ResponseEntity<RespostaPadrao>  consultaSituacaoEnvasadora(@RequestBody @Valid SituacaoEnvasadoraDTO dto) {

		RespostaPadrao resposta = this.comunicacaoGraficasService.verificaSituacaoEnvasora(dto);
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@PostMapping(value = "/situacaoGrafica")
	public ResponseEntity<RespostaPadrao> consultaSituacaoGrafica(@RequestBody @Valid TokenRequestDTO dto) {
		
		RespostaPadrao resposta = this.tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
}
