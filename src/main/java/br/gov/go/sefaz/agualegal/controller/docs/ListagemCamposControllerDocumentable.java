package br.gov.go.sefaz.agualegal.controller.docs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.gov.go.sefaz.agualegal.domain.Resposta;
import br.gov.go.sefaz.agualegal.domain.RespostaPreAnalise;
import br.gov.go.sefaz.agualegal.domain.dto.ListaDTO;
import br.gov.go.sefaz.agualegal.domain.dto.SolicitacaoGraficaDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.CadastroDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.EnderecoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.LicencaDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ResponsavelDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Listagem de campos para envasadora", description = "Serviços de listagem de campos para envasadora")
public interface ListagemCamposControllerDocumentable {

	@Operation(summary = "Listagem de campos envasadora", description = "Serviço que devolve para a gráfica as informações a serem informadas pela envasadora, bem como sua obrigatoriedade e tipo de análise")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK: consulta efetuada e dados retornados com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ListaDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized: Gráfica não autorizada a utilizar o sistema! Token ou CNPJ podem ter sido informados incorretamente",content = @Content(mediaType = "application/json", schema = @Schema(implementation = Resposta.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json")) })
	@Parameters(value = { 				
			@Parameter(name = "solicitacao", description = "Objeto que encapsula as informações de CNPJ da gráfica e token", required = true, schema = @Schema(implementation = SolicitacaoGraficaDTO.class))
	})
	public ResponseEntity<ListaDTO> listaCampos(@Valid @RequestBody SolicitacaoGraficaDTO dto);
}

