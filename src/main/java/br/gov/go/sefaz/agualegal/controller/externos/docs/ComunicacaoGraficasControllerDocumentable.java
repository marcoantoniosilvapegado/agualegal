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

@Tag(name = "Serviços de comunicação - Gráficas", description = "Endpoints relacionados à comunicação com gráficas")
public interface ComunicacaoGraficasControllerDocumentable {
	
	@Operation(summary = "Consulta situação envasadora", description = "Este serviço retorna a situação da envasadora com base nos dados fornecidos")
	@Parameters(value = {
		        @Parameter(name = "inscricaoEstadual", description = "Inscrição estadual da empresa envasadora", required = true),
		        @Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true),
		        @Parameter(name = "tipoAgua", description = "Tipo de água manipulado pela envasadora: 1(Água de sais),2(água mineral)ou 3(ambos)", required = true)
		    })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK: Requisição bem-sucedida"), 
        @ApiResponse(responseCode = "400", description = "Bad Request: Parâmetros inválidos"),
        @ApiResponse(responseCode = "401", description = "Unauthorized: Falha na autenticação"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor")
    })
	public ResponseEntity<RespostaPadrao>  consultaSituacaoEnvasadora(@RequestBody @Valid SituacaoEnvasadoraDTO dto);
	
	
	@Operation(summary = "Consulta situação gráfica", description = "Este serviço retorna a situação da gráfica, verificando se a mesma está autorizada a utilizar o sistema")
	@Parameters(value = {		      
		        @Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true)		       
		    })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK: Gráfica autorizada a utilizar o sistema!"), 
        @ApiResponse(responseCode = "400", description = "Bad Request: Gráfica não encontrada ou não autorizada a utilizar o sistema!"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor")
    })
	public ResponseEntity<RespostaPadrao> consultaSituacaoGrafica(@RequestBody @Valid TokenRequestDTO dto);
}
