package br.gov.go.sefaz.agualegal.controller.docs;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.ListaCamposRequestDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposResponseDTO;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.dto.TokenRequestDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.CadastroDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.LicencaDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ResponsavelDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Serviços de comunicação - Gráficas", description = "Endpoints relacionados à comunicação com gráficas")
public interface ComunicacaoGraficasControllerDocumentable {

	@Operation(summary = "Consulta situação gráfica", description = "Este serviço retorna a situação da gráfica, verificando se a mesma está autorizada a utilizar o sistema")
	@Parameters(value = {
			@Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true, schema = @Schema(type = "string")) })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK: Gráfica autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaPadrao.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request: Houve problema na solicitação!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "401", description = "Unauthorized: Gráfica não encontrada ou não autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json")) })
	public ResponseEntity<RespostaPadrao> consultaSituacaoGrafica(@RequestBody @Valid TokenRequestDTO dto);

	@Operation(summary = "Consulta situação envasadora", description = "Este serviço retorna a situação da envasadora com base nos dados fornecidos")
	@Parameters(value = {
			@Parameter(name = "inscricaoEstadual", description = "Inscrição estadual da empresa envasadora", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true, schema = @Schema(type = "string")) })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK: Requisição bem-sucedida - Envasadora apta a solicitar credenciamento!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaPadrao.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request: Envasadora não autorizada a solicitar credenciamento", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "401", description = "Unauthorized: Gráfica não encontrada ou não autorizada a utilizar o sistema", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json")) })
	public ResponseEntity<RespostaPadrao> consultaSituacaoEnvasadora(@RequestBody @Valid SituacaoEnvasadoraDTO dto);

	@Operation(summary = "Listagem de campos", description = "Este serviço retorna os campos a serem informados pela envasadora quando a mesma for solicitar seu credenciamento no sistema água legal")
	@Parameters(value = {
			@Parameter(name = "inscricaoEstadual", description = "Inscrição estadual da empresa envasadora", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tipoAgua", description = "Tipo de água: 1 - Adicionada de Sais; 2 - Mineral; 3 - Ambas", required = true, schema = @Schema(type = "string")) })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK: Dados retornados com sucesso ao solicitante!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ListaCamposResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request: Houve problema na solicitação!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "401", description = "Unauthorized: Gráfica não encontrada ou não autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json")) })
	public ResponseEntity<ListaCamposResponseDTO> listarCamposEnvasadora(@RequestBody ListaCamposRequestDTO dto);
	
	@Operation(summary = "Solicitação de credenciamento", description = "Este serviço recebe os dados necessários para a solicitação de credenciamento da empresa envasadora")
	@Parameters(value = {
			@Parameter(name = "DadosSolicitacaoDTO", description = "Classe DTO que define todos os dados necessários na solicitação de credenciamento", required = true, schema = @Schema(implementation = DadosSolicitacaoDTO.class)), 
			@Parameter(name = "cadastro", description = "Objeto que encapsula as informações de cadastro da envasadora", required = true, schema = @Schema(implementation = CadastroDTO.class)),
			@Parameter(name = "responsavel", description = "Objeto que encapsula as informações de cadastro do responsável pela envasadora", required = true, schema = @Schema(implementation = ResponsavelDTO.class)),
			@Parameter(name = "licencaVigilancia", description = "Objeto que encapsula as informações da licença da vigilância sanitária", required = true, schema = @Schema(implementation = LicencaDTO.class)),
			@Parameter(name = "licencaMineracao", description = "Objeto que encapsula as informações da licença da agência nacional de mineração", required = true, schema = @Schema(implementation = LicencaDTO.class)),
			@Parameter(name = "enderecoEnvasador", description = "Endereço da empresa envasadora", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "coordenadasEnvasador", description = "Coordenadas referentes ao endereço da envasadora", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "enderecoEnvase", description = "Endereço do local de envasamento", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "coordenadasEnvase", description = "Coordenadas referentes ao local de envasamento", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tipoAgua", description = "Tipo de água: 1 - Adicionada de Sais; 2 - Mineral; 3 - Ambas", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "observacao", description = "Observações gerais sobre a solicitação", required = true, schema = @Schema(type = "string"))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK: Solicitação de credenciamento efetuada com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaPadrao.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request: Houve problema na solicitação de credenciamento!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "401", description = "Unauthorized: Gráfica não encontrada ou não autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json")) })
	public ResponseEntity<RespostaPadrao> solicitarCredenciamentoEnvasadora(
			@RequestBody @Valid DadosSolicitacaoDTO dto
			);
	
	/*@Operation(summary = "Solicitação de credenciamento", description = "Este serviço recebe os dados necessários para a solicitação de credenciamento da empresa envasadora")
	@Parameters(value = {
			@Parameter(name = "inscricaoEstadual", description = "Inscrição estadual da empresa envasadora", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tipoAgua", description = "Tipo de água: 1 - Adicionada de Sais; 2 - Mineral; 3 - Ambas", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "nomeGrafica", description = "Nome da gráfica intermediadora do procedimento de solicitação de credenciamento", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "cnpjGrafica", description = "CNPJ da gráfica intermediadora do procedimento de solicitação de credenciamento", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "listaCampos", description = "Lista de informações textuais solicitadas à empresa envasadora. ", required = true, schema = @Schema(implementation = CampoDTO.class)),
			@Parameter(name = "listaArquivos", description = "Lista de arquivos (PDF, IMAGEM) solicitados à gráfica. ", required = true, schema = @Schema(implementation = ArquivoDTO.class)),
			@Parameter(name = "listaProdutos", description = "Lista com informações referentes aos produtos oferecidos pela empresa envasadora. ", required = true, schema = @Schema(implementation = ProdutoDTO.class)) 
			})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK: Solicitação de credenciamento efetuada com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaPadrao.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request: Houve problema na solicitação de credenciamento!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "401", description = "Unauthorized: Gráfica não encontrada ou não autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json")) })
	public ResponseEntity<RespostaPadrao> solicitarCredenciamentoEnvasadora(
			@RequestBody @Valid SolicitacaoCredenciamentoDTO dto);*/
	

	/*@Operation(summary = "Solicitação de credenciamento", description = "Este serviço recebe os dados necessários para a solicitação de credenciamento da empresa envasadora")
	@Parameters(value = {
			@Parameter(name = "inscricaoEstadual", description = "Inscrição estadual da empresa envasadora", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tokenGrafica", description = "Token de autenticação fornecido pela gráfica", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "tipoAgua", description = "Tipo de água: 1 - Adicionada de Sais; 2 - Mineral; 3 - Ambas", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "nomeGrafica", description = "Nome da gráfica intermediadora do procedimento de solicitação de credenciamento", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "cnpjGrafica", description = "CNPJ da gráfica intermediadora do procedimento de solicitação de credenciamento", required = true, schema = @Schema(type = "string")),
			@Parameter(name = "listaCampos", description = "Lista de informações textuais solicitadas à empresa envasadora. ", required = true, schema = @Schema(implementation = CampoDTO.class)),
			@Parameter(name = "listaArquivos", description = "Lista de arquivos (PDF, IMAGEM) solicitados à gráfica. ", required = true, schema = @Schema(implementation = ArquivoDTO.class)),
			@Parameter(name = "listaProdutos", description = "Lista com informações referentes aos produtos oferecidos pela empresa envasadora. ", required = true, schema = @Schema(implementation = ProdutoDTO.class)) })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK: Solicitação de credenciamento efetuada com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaPadrao.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request: Houve problema na solicitação de credenciamento!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "401", description = "Unauthorized: Gráfica não encontrada ou não autorizada a utilizar o sistema!", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal Server Error: Erro no servidor", content = @Content(mediaType = "application/json")) })
	public ResponseEntity<RespostaPadrao> solicitarCredenciamentoEnvasadoraNew(
			@RequestBody @Valid DadosSolicitacaoDTO dto);
*/
}
