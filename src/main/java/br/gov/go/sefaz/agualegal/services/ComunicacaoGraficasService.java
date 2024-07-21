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
import br.gov.go.sefaz.agualegal.dto.solicitacao.ArquivoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
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
		List<CampoResponseDTO> listaCampos = comunicacaoGraficasRepository.listaCamposEnvasadora(dto.getTipoAgua());

		return new ListaCamposResponseDTO(listaCampos);
	}
	
	public RespostaPadrao solicitaCredenciamentoEnvasadora(
			SolicitacaoCredenciamentoDTO dto			
			) {
		tokenGraficasService.verificaTokenGrafica(dto.getTokenGrafica());
		System.out.println("êxito - tamanho arquivo: " + dto.getListaProdutos().get(0).getFotoRecipienteBase().length);
		return null;
	}

}
