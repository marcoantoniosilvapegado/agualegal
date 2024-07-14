package br.gov.go.sefaz.agualegal.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;
import br.gov.go.sefaz.agualegal.dto.CampoResponseDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposResponseDTO;
import br.gov.go.sefaz.agualegal.dto.ListaCamposRequestDTO;
import br.gov.go.sefaz.agualegal.dto.SituacaoEnvasadoraDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.SolicitacaoCredenciamentoDTO;
import br.gov.go.sefaz.agualegal.enums.MENSAGENSPADRAO;
import br.gov.go.sefaz.agualegal.exception.EnvasadoraRegrasException;
import br.gov.go.sefaz.agualegal.exception.TokenGraficaInvalidoException;
import br.gov.go.sefaz.agualegal.repository.ComunicacaoGraficasRepository;

@Service
public class ComunicacaoGraficasService {

	private TokenGraficasService tokenGraficasService;

	private ComunicacaoGraficasRepository comunicacaoGraficasRepository;

	public ComunicacaoGraficasService(TokenGraficasService tokenGraficasService,
			ComunicacaoGraficasRepository comunicacaoGraficasRepository) {
		this.tokenGraficasService = tokenGraficasService;
		this.comunicacaoGraficasRepository = comunicacaoGraficasRepository;
	}

	public RespostaPadrao verificaSituacaoEnvasora(SituacaoEnvasadoraDTO dto) {

		/* Verifica se token da gráfica é válido */
		tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());	
		
		/* Verifica se a envasadora está na lista de exceção 
		 * Caso esteja, será concedida a permissão. Caso não, o fluxo seguirá e outras verificações serão feitas*/
		Boolean envasadoraListaExcecao = comunicacaoGraficasRepository
				.verificaEnvasadoraListaExcecao(dto.getInscricaoEstadual());
		
		if(envasadoraListaExcecao) {
			return new RespostaPadrao(MENSAGENSPADRAO.ENVASADORALISTAEXCECAO.getDesc(), 1, true);
		}
		
		/* Verifica inicialmente se a envasadora existe no cadastro */
		Boolean envasadoraExisteCadastro = comunicacaoGraficasRepository
				.verificaEnvasadoraExisteCadastro(dto.getInscricaoEstadual());
		
		if(!envasadoraExisteCadastro) {
			throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORANAOEXISTE.getDesc(), 2);
		}			
		
		/*Verifica se a envasadora possui situação cadastral ativa*/
		Boolean envasadoraCadastroAtivo =  
			comunicacaoGraficasRepository.verificaEnvasadoraSituacaoAtiva(dto.getInscricaoEstadual());
		if(!envasadoraCadastroAtivo) {
			throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORASITFISCINATIVA.getDesc(), 3);
		}
		
		
		/*Verifica se a envasadora possui o CNAE de envasamento*/
		Boolean envasadoraPossuiCnae = comunicacaoGraficasRepository.verificaEnvasadoraPossuiCnae(dto.getInscricaoEstadual());
		if(!envasadoraPossuiCnae) {
			throw new EnvasadoraRegrasException(MENSAGENSPADRAO.ENVASADORANAOINCLUIDACNAE.getDesc(), 5);
		}
	
		return new RespostaPadrao(MENSAGENSPADRAO.ENVASADORAPERMITIDA.getDesc(), 4, true);
	}

	public ListaCamposResponseDTO listaCamposEnvasadora(ListaCamposRequestDTO dto) {

		tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());

		List<CampoResponseDTO> listaCampos = this.mockCamposEnvasadora(dto.getTipoAgua());

		return new ListaCamposResponseDTO(listaCampos);
	}

	private List<CampoResponseDTO> mockCamposEnvasadora(String tipoAgua) {

		CampoResponseDTO campo1 = new CampoResponseDTO("CNPJ", "CNPJ da empresa envasadora", "Análise Cadastral",
				"Texto", true);
		CampoResponseDTO campo2 = new CampoResponseDTO("Razão Social", "Razão Social da empresa envasadora",
				"Análise Cadastral", "Texto", true);
		CampoResponseDTO campo3 = new CampoResponseDTO("Nome Fantasia", "Nome Fantasia da empresa envasadora",
				"Análise Cadastral", "Texto", true);
		CampoResponseDTO campo4 = new CampoResponseDTO("Endereço Envasador", "Endereço da empresa envasadora",
				"Análise Cadastral", "Texto", true);
		CampoResponseDTO campo5 = new CampoResponseDTO("Endereço Local",
				"Endereço do local de envase da empresa envasadora", "Análise Cadastral", "Texto", true);
		CampoResponseDTO campo6 = new CampoResponseDTO("Email", "Email do responsável pelo Envasador",
				"Análise Cadastral", "Texto", true);
		CampoResponseDTO campo7 = new CampoResponseDTO("Cpf", "CPF do responsável pelo Envasador", "Análise Cadastral",
				"Texto", true);
		CampoResponseDTO campo8 = new CampoResponseDTO("RG", "RG do responsável pelo Envasador", "Análise Cadastral",
				"Texto", false);
		CampoResponseDTO campo9 = new CampoResponseDTO("Telefone", "Telefone do responsável pelo Envasador",
				"Análise Cadastral", "Texto", true);

		CampoResponseDTO campo10 = new CampoResponseDTO("Emissor da licença Sanitária",
				"Órgão responsável pela emissão da licença sanitária", "Análise Sanitária", "Texto", true);
		CampoResponseDTO campo11 = new CampoResponseDTO("Imagem da licença", "Imagem da Licença Sanitária",
				"Análise sanitária", "Imagem", true);
		CampoResponseDTO campo12 = new CampoResponseDTO("Licença sanitária",
				"Arquivo no formato PDF da licença sanitária", "Análise sanitária", "PDF", true);
		CampoResponseDTO campo13 = new CampoResponseDTO("Número Licença", "Número identificador da Licença Sanitária",
				"Análise Sanitária", "Texto", true);

		CampoResponseDTO campo14 = new CampoResponseDTO("Emissor da licença mineral",
				"Órgão responsável pela emissão da licença mineral", "Análise mineral", "Texto", true);
		CampoResponseDTO campo15 = new CampoResponseDTO("Imagem da mineral", "Imagem da Licença mineral",
				"Análise mineral", "Imagem", true);
		CampoResponseDTO campo16 = new CampoResponseDTO("Licença mineral", "Arquivo no formato PDF da licença mineral",
				"Análise Mineral", "PDF", true);
		CampoResponseDTO campo17 = new CampoResponseDTO("Número Licença mineral",
				"Número identificador da Licença da Agência Nacional de Mineração", "Análise Mineral", "Texto", true);

		CampoResponseDTO campo18 = new CampoResponseDTO("CND", "Certidão Negativa de Débito", "Análise Fiscal", "PDF",
				true);
		CampoResponseDTO campo19 = new CampoResponseDTO("Nada Consta",
				"Nada Consta da envasadora quanto a débitos/processos trabalhistas", "Análise Fiscal", "PDF", true);
		List<CampoResponseDTO> list = new ArrayList();
		list.add(campo1);
		list.add(campo2);
		list.add(campo3);
		list.add(campo4);
		list.add(campo5);
		list.add(campo6);
		list.add(campo7);
		list.add(campo8);
		list.add(campo9);
		list.add(campo10);
		list.add(campo11);
		list.add(campo12);
		list.add(campo13);
		// List<CampoResponseDTO> list = Arrays.asList(campo1, campo2, campo3, campo4,
		// campo5, campo6, campo7, campo8, campo9, campo10,
		// campo11, campo12, campo13);

		if (!tipoAgua.equals("1")) {
			// list.addAll(Arrays.asList(campo14, campo15, campo16, campo17));
			list.add(campo14);
			list.add(campo15);
			list.add(campo16);
			list.add(campo17);
		}

		list.add(campo18);
		list.add(campo19);

		return list;

	}

	public RespostaPadrao solicitaCredenciamentoEnvasadora(@Valid SolicitacaoCredenciamentoDTO dto) {
		tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());
		System.out.println(dto);
		return null;
	}

}
