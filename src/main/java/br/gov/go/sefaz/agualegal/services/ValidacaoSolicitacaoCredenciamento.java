package br.gov.go.sefaz.agualegal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.dto.solicitacao.ArquivoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.SolicitacaoCredenciamentoDTO;
import br.gov.go.sefaz.agualegal.exception.ValidacaoSolicitacaoException;
import br.gov.go.sefaz.agualegal.exception.ValidationError;
import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;
import br.gov.go.sefaz.agualegal.repository.CampoFormularioRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class ValidacaoSolicitacaoCredenciamento {

	private CampoFormularioRepository campoFormularioRepository;

	public ValidacaoSolicitacaoCredenciamento(CampoFormularioRepository campoFormularioRepository) {
		this.campoFormularioRepository = campoFormularioRepository;
	}

	public void validacaoDadosSolicitacaoCredenciamento(SolicitacaoCredenciamentoDTO dto) {

		ValidationError errors = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
				System.currentTimeMillis());
						
		/* Inicializa lista de validações */
		errors.setList(new ArrayList<>());

		/* Inicialmente, será feita validação sob a lista de produtos */
		this.validaListaProdutos(dto.getListaProdutos(), errors);

		/*
		 * Verifica se em listaCampos e listaArquivos foram enviados os dados
		 * necessários para a solicitação, bem como com os formatos pre etabelecidos
		 */
		this.validaCamposObrigatorios(dto, errors);

		/*
		 * Se um ou mais erros foram encontrados ao longo da validação, retorna exceção
		 * com o conteúdo dos erros encontrados
		 */
		if (errors.hasErrors()) {
			throw new ValidacaoSolicitacaoException(errors);
		}

	}

	private void validaCamposObrigatorios(SolicitacaoCredenciamentoDTO dto, ValidationError errors) {
		/* Carrega lista de campos configurados para envio */
		List<CampoFormulario> listaCamposConfiguracao = this.campoFormularioRepository
				.findCamposObrigatoriosFormulario(dto.getTipoAgua()).get();

		/*Cria uma lista de String com os campos configurados para simplificar a verificação*/
		List<String> listaCamposConfigurados = listaCamposConfiguracao.stream().map(item -> item.getNomeCriterio())
				.collect(Collectors.toList());

		/*Monta uma List<String> com as descrições dos campos enviados pelo usuário>*/
		List<String> listaCamposEnviados = dto.getListaCampos().stream().map(item -> item.getNomeCampo())
				.collect(Collectors.toList());
		
		/*Monta uma List<String> com as descrições dos campos referentes a arquivos enviados pelo usuário,
		 * e agrega na lista anterior>*/
		listaCamposEnviados
				.addAll(dto.getListaArquivos().stream().map(item -> item.getNomeCampo()).collect(Collectors.toList()));

		/*Faz um de-para entre campos configurados e campos enviados pela gráfica.*/
		List<String> listaCamposFaltantes = UtilsAguaLegal.filtrarItensLista(listaCamposConfigurados,
				listaCamposEnviados);

		/*Se ess lista não está vazia, é indício de que houve campos não enviados pela gráfica
		 * As mensagens referentes a cada campo serão inseridas na coleção, e será encerrada aqui a validação*/
		if (!listaCamposFaltantes.isEmpty()) {
			for (int i = 0; i < listaCamposFaltantes.size(); i++) {
				errors.addError("Campo não encontrado", listaCamposFaltantes.get(i));
			}
		} else {
			/*
			 * Se todos os campos foram enviados, verificar se nos campos de arquivo foi
			 * enviado o byte[] de formato correto, não vazio e respeitando o tamanho limite de imagem,
			 * em caso de a informação estar assim configurada (2MB)
			 */

			this.validaArquivosEnviados(listaCamposConfiguracao, dto, errors);

		}

	}

	private void validaArquivosEnviados(List<CampoFormulario> listaCamposConfiguracao, SolicitacaoCredenciamentoDTO dto,
			ValidationError errors) {

//		listaCamposConfiguracao.stream().forEach(item -> System.out.println(item.getTipoResposta().getTipoResposta()));

		/*Cria uma coleção dos campos de formulario referentes a arquivos(ou seja, não textuais)*/
		List<CampoFormulario> listaCamposArquivo = listaCamposConfiguracao.stream()
				.filter(item -> !item.getTipoResposta().getTipoResposta().equals("TEXTO")).collect(Collectors.toList());

		List<ArquivoDTO> listaArquivos = dto.getListaArquivos();

		/*Varre a lista de arquivos recebidos para fazer as validações necessárias*/
		for (int i = 0; i < listaArquivos.size(); i++) {
			
			ArquivoDTO arquivo = listaArquivos.get(i);
			
			/*Consulta o CampoFormulario referente àquele registro recebido, para fazer a validação de se
			 * o formato do arquivo recebido é o mesmo que está configurado*/
			CampoFormulario campoFormulario = listaCamposArquivo.stream().filter(item -> {
				return item.getNomeCriterio().equals(arquivo.getNomeCampo());
			}).findFirst().get();

			/*Se há byte[] enviado*/
			if (UtilsAguaLegal.isNotEmpty(arquivo.getFile())) {
				/*Valida formato. IMAGEM , PDF*/
				if (!UtilsAguaLegal.detectarExtensaoConteudo(arquivo.getFile())
						.equals(campoFormulario.getTipoResposta().getTipoResposta())) {
					errors.addError(arquivo.getNomeCampo(), "Formato do arquivo enviado incorretamente. Era esperado "
							+ campoFormulario.getTipoResposta().getTipoResposta());
				} else {
					if (!UtilsAguaLegal.verificaTamanhoImagemValido(arquivo.getFile())) {
						errors.addError(arquivo.getNomeCampo(),
								"O tamanho da imagem referente ao campo excedeu o limite de 2 MB");
					}
				}
			} else {
				/*Se o byte[] está vazio ou nulo*/
				errors.addError(arquivo.getNomeCampo(), "Conteúdo do arquivo enviado está vazio");
			}

		}

	}

	private void validaListaProdutos(List<ProdutoDTO> listaProdutos, ValidationError errors) {

		/* Verificar campos vazios, formato das imagens e tamanho */
		for (int i = 0; i < listaProdutos.size(); i++) {
			ProdutoDTO produto = listaProdutos.get(i);
			Integer numeroProduto = i + 1;
			if (UtilsAguaLegal.isEmpty(produto.getTipo())) {
				errors.addError("Produto - " + numeroProduto, "Tipo deve ser informado");
			}
			if (UtilsAguaLegal.isEmpty(produto.getDescricaoMarca())) {
				errors.addError("Produto - " + numeroProduto, "Descrição da marca ser informada");
			}
			if (UtilsAguaLegal.isEmpty(produto.getTipoEmbalagem())) {
				errors.addError("Produto - " + numeroProduto, "Tipo de embalagem deve ser informada");
			}
			if (UtilsAguaLegal.isEmpty(produto.getVolume())) {
				errors.addError("Produto - " + numeroProduto, "Volume deve ser informado");
			}

			if (!UtilsAguaLegal.isNotEmpty(produto.getFotoRecipienteBase())) {
				errors.addError("Produto - " + numeroProduto, "Foto do recipiente deve ser informada");
			} else {
				if (!UtilsAguaLegal.isImage(produto.getFotoRecipienteBase())) {
					errors.addError("Produto - " + numeroProduto,
							"O arquivo referente ao recipiente deve ser uma imagem");
				} else {
					if (!UtilsAguaLegal.verificaTamanhoImagemValido(produto.getFotoRecipienteBase())) {
						errors.addError("Produto - " + numeroProduto,
								"O arquivo referente ao recipiente excedeu o tamanho definido de 2MB");
					}
				}
			}

			if (!UtilsAguaLegal.isNotEmpty(produto.getImagemRotuloBase())) {
				errors.addError("Produto - " + numeroProduto, "Imagem do rótulo deve ser informada");
			} else {
				if (!UtilsAguaLegal.isImage(produto.getImagemRotuloBase())) {
					errors.addError("Produto - " + numeroProduto, "O arquivo referente ao rótulo deve ser uma imagem");
				} else {
					if (!UtilsAguaLegal.verificaTamanhoImagemValido(produto.getImagemRotuloBase())) {
						errors.addError("Produto - " + numeroProduto,
								"O arquivo referente ao rótulo excedeu o tamanho definido de 2MB");
					}
				}
			}

		}

	}

}
