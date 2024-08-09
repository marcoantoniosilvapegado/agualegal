package br.gov.go.sefaz.agualegal.controller.docs;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import br.gov.go.sefaz.agualegal.domain.RespostaPreAnalise;
import br.gov.go.sefaz.agualegal.dto.solicitacao.CadastroDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.EnderecoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.LicencaDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ResponsavelDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

public interface CredenciamentoEnvasadoraControllerDocumentable {
	
	@Operation(summary = "Pré-Análise/Solicitação de credenciamento", description = "Este serviço recebe os dados necessários para a execução da pré-analise fiscal, e da solicitação de credenciamento da empresa envasadora")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK: pré-análise deferida e solicitação de credenciamento salva com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaPreAnalise.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request: Problema na solicitação! Indeferimento da pré-análise ou dados inválidos na requisição", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "401", description = "Unauthorized: Gráfica não autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json")) })
	@Parameters(value = { 				
			@Parameter(name = "cadastro", description = "Objeto que encapsula as informações de cadastro da envasadora", required = true, schema = @Schema(implementation = CadastroDTO.class)),
			@Parameter(name = "responsavel", description = "Objeto que encapsula as informações de cadastro do responsável pela envasadora", required = true, schema = @Schema(implementation = ResponsavelDTO.class)),
			@Parameter(name = "licencaVigilancia", description = "Objeto que encapsula as informações da licença da vigilância sanitária", required = true, schema = @Schema(implementation = LicencaDTO.class)),
			@Parameter(name = "licencaMineracao", description = "Objeto que encapsula as informações da licença da agência nacional de mineração", required = true, schema = @Schema(implementation = LicencaDTO.class)),
			@Parameter(name = "enderecoDTO", description = "Objeto que encapsula as informações de endereço da envasadora e local de envase", required = true, schema = @Schema(implementation = EnderecoDTO.class)),
			@Parameter(name = "listaProdutos", description = "Lista com informações referentes aos produtos oferecidos pela empresa envasadora. ", required = true, schema = @Schema(implementation = ProdutoDTO.class, type = "array")),
			@Parameter(name = "tipoAgua", description = "Tipo de água com a qual a empresa envasadora trabalha: 1 - Mineral; 2 - Adicionada de Sais; 3 - Ambas", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "observacao", description = "Observações gerais sobre a solicitação de credenciamento", required = false, schema = @Schema(type = "string")),
			@Parameter(name = "cnpjGrafica", description = "CNPJ da gráfica que está intermediando a operação de solicitação de credenciamento", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tokenGrafica", description = "Token de acesso da gráfica que está intermediando a operação de solicitação de credenciamento", required = true, schema = @Schema(type = "string"))
	})
	public ResponseEntity<RespostaPreAnalise> solicitarCredenciamentoEnvasadora(
			@RequestBody @Valid DadosSolicitacaoDTO dto);
}
