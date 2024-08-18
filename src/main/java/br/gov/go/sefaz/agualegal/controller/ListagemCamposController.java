package br.gov.go.sefaz.agualegal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.go.sefaz.agualegal.controller.docs.ListagemCamposControllerDocumentable;
import br.gov.go.sefaz.agualegal.domain.dto.ListaDTO;
import br.gov.go.sefaz.agualegal.domain.dto.SolicitacaoGraficaDTO;
import br.gov.go.sefaz.agualegal.services.ListagemCamposService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/credenciamento")
public class ListagemCamposController implements ListagemCamposControllerDocumentable {

	private ListagemCamposService listagemCamposService;

	public ListagemCamposController(ListagemCamposService listagemCamposService) {
		this.listagemCamposService = listagemCamposService;
	}

	@PostMapping(value = "/listaCampos")
	public ResponseEntity<ListaDTO> listaCampos(@Valid @RequestBody SolicitacaoGraficaDTO dto) {

		ListaDTO lista = this.listagemCamposService.retornaListagemCampos(dto);
		return new ResponseEntity<ListaDTO>(lista, HttpStatus.OK);
	}

}
