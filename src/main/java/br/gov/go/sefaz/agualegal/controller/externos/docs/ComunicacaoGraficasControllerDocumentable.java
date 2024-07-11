package br.gov.go.sefaz.agualegal.controller.externos.docs;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.dto.TokenRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

@Tag(name = "Serviços de comunicação - Gráficas", description = "Endpoints relacionados à comunicação com gráficas")
public interface ComunicacaoGraficasControllerDocumentable {
	
	@Operation(summary = "Consulta situação envasadora", description = "Este serviço retorna a situação da envasadora com base nos dados fornecidos")
	@Parameters(value = {
		        @Parameter(name = "inscricaoEstadual", description = "Inscrição estadual da empresa envasadora", required = true, schema = @Schema(type = "string")),
		        @Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true, schema = @Schema(type = "string")),
		        @Parameter(name = "tipoAgua", description = "Tipo de água manipulado pela envasadora: 1(Água de sais),2(água mineral)ou 3(ambos)", required = true, schema = @Schema(type = "string"))
		    })
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK: Requisição bem-sucedida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaPadrao.class))),
	        @ApiResponse(responseCode = "400", description = "Bad Request: Parâmetros inválidos", content = @Content(mediaType = "application/json")),
	        @ApiResponse(responseCode = "401", description = "Unauthorized: Falha na autenticação", content = @Content(mediaType = "application/json")),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json"))
	})
	public ResponseEntity<RespostaPadrao>  consultaSituacaoEnvasadora(@RequestBody @Valid SituacaoEnvasadoraDTO dto);
	
	
	@Operation(summary = "Consulta situação gráfica", description = "Este serviço retorna a situação da gráfica, verificando se a mesma está autorizada a utilizar o sistema")
		@Parameters(value = {
				@Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true, schema = @Schema(type = "string")) })
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK: Gráfica autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaPadrao.class))),
	        @ApiResponse(responseCode = "400", description = "Bad Request: Gráfica não encontrada ou não autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json")),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json"))
	    })
	public ResponseEntity<RespostaPadrao> consultaSituacaoGrafica(@RequestBody @Valid TokenRequestDTO dto);
}
