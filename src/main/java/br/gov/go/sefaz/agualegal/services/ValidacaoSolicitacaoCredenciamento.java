package br.gov.go.sefaz.agualegal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.exception.ValidacaoSolicitacaoException;
import br.gov.go.sefaz.agualegal.exception.ValidationError;
import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;
import br.gov.go.sefaz.agualegal.modelo.EmissorLicenca;
import br.gov.go.sefaz.agualegal.modelo.TipoAgua;
import br.gov.go.sefaz.agualegal.repository.CampoFormularioRepository;
import br.gov.go.sefaz.agualegal.repository.EmissorLicencaRepository;
import br.gov.go.sefaz.agualegal.repository.GraficaRepository;
import br.gov.go.sefaz.agualegal.repository.TipoAguaRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class ValidacaoSolicitacaoCredenciamento {

	private CampoFormularioRepository campoFormularioRepository;
	private TipoAguaRepository tipoAguaRepository;
	private EmissorLicencaRepository emissorLicencaRepository;
	private GraficaRepository graficaRepository;

	public ValidacaoSolicitacaoCredenciamento(CampoFormularioRepository campoFormularioRepository,
			TipoAguaRepository tipoAguaRepository, EmissorLicencaRepository emissorLicencaRepository,
			GraficaRepository graficaRepository) {
		super();
		this.campoFormularioRepository = campoFormularioRepository;
		this.tipoAguaRepository = tipoAguaRepository;
		this.emissorLicencaRepository = emissorLicencaRepository;
		this.graficaRepository = graficaRepository;
	}

	public void validacaoDadosSolicitacaoCredenciamento(DadosSolicitacaoDTO dto) {

		ValidationError errors = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
				System.currentTimeMillis());

		/* Inicializa lista de validações */
		errors.setList(new ArrayList<>());

		/* Inicialmente, será feita validação sob a lista de produtos */
		this.validaListaProdutos(dto.getListaProdutos(), errors);

		/* Valida os campos do formulário */
		this.validaCamposFormulario(dto, errors);

		if (errors.hasErrors()) {
			throw new ValidacaoSolicitacaoException(errors);
		}
	}

	private void validaCamposRestantes(DadosSolicitacaoDTO dto, ValidationError errors, List<CampoFormulario> list) {

		CampoFormulario campoObservacao = list.stream().filter(item -> item.getCodigoCriterio().equals("OBSERVACAO"))
				.collect(Collectors.toList()).get(0);
		CampoFormulario campoTipoAgua = list.stream().filter(item -> item.getCodigoCriterio().equals("TIPOAGUA"))
				.collect(Collectors.toList()).get(0);

		if (UtilsAguaLegal.isEmpty(dto.getObservacao())
				&& (campoObservacao != null && campoObservacao.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Observação");
		}

		if (UtilsAguaLegal.isEmpty(dto.getTipoAgua())) {
			if (campoTipoAgua != null && campoTipoAgua.getCampoObrigatorio() == 'S') {
				errors.addError("Tipo de água", "Campo não informado");
			}
		} else {
			Optional<TipoAgua> tipoAgua = this.tipoAguaRepository.findById(Integer.parseInt(dto.getTipoAgua()));
			if (tipoAgua.isEmpty()) {
				errors.addError("Tipo de água", "Tipo de água informado inválido");
			}
		}

		if (UtilsAguaLegal.isEmpty(dto.getCnpjGrafica())) {
			errors.addError("Campo não informado", "CNPJ da Gráfica");
		} else {
			if (!UtilsAguaLegal.verificaCnpjValido(dto.getCnpjGrafica())) {
				errors.addError("Conteúdo de campo inválido", "CNPJ gráfica");
			} else {
				if (this.graficaRepository.findByCnpj(dto.getCnpjGrafica()).isEmpty()) {
					errors.addError("Gráfica não encontrada na base", "CNPJ gráfica");
				}
			}
		}

	}

	private void validaCamposFormulario(DadosSolicitacaoDTO dto, ValidationError errors) {
		List<CampoFormulario> list = campoFormularioRepository.findCamposAtivosFormulario().get();

		this.validaCamposCadastroEnvasadora(dto, errors, list);
		this.validaCamposResponsavelEnvasadora(dto, errors, list);
		this.validaCamposEnderecoEnvase(dto, errors, list);
		this.validaLicencas(dto, errors, list);
		this.validaCamposRestantes(dto, errors, list);

	}

	private void validaLicencas(DadosSolicitacaoDTO dto, ValidationError errors, List<CampoFormulario> list) {

		CampoFormulario emissorLicencaSanitaria = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("EMISSORLICENCASANITARIA")).collect(Collectors.toList())
				.get(0);

		CampoFormulario imagemLicencaSanitaria = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("IMAGEMLICENCASANITARIA")).collect(Collectors.toList())
				.get(0);

		CampoFormulario numeroLicencaSanitaria = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("NUMEROLICENCASANITARIA")).collect(Collectors.toList())
				.get(0);

		CampoFormulario imagemLicencaMineral = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("IMAGEMLICENCAMINERAL")).collect(Collectors.toList())
				.get(0);

		CampoFormulario numeroLicencaMineral = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("NUMEROLICENCAMINERAL")).collect(Collectors.toList())
				.get(0);

		if (dto.getLicencaVigilancia().getEmissorLicenca() == null
				&& (emissorLicencaSanitaria != null && emissorLicencaSanitaria.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Emissor licença sanitária");
		} else {
			Optional<EmissorLicenca> emissorLicenca = this.emissorLicencaRepository
					.findById(dto.getLicencaVigilancia().getEmissorLicenca());
			if (emissorLicenca.isEmpty()) {
				errors.addError("Emissor não identificado", "Emissor da licença sanitária");
			}

		}

		if (UtilsAguaLegal.isEmpty(dto.getLicencaVigilancia().getNumero())
				&& (numeroLicencaSanitaria != null && numeroLicencaSanitaria.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Número licença sanitária");
		}

		if (!UtilsAguaLegal.isNotEmpty(dto.getLicencaVigilancia().getImagem())) {
			if (imagemLicencaSanitaria != null && imagemLicencaSanitaria.getCampoObrigatorio() == 'S') {
				errors.addError("Campo não informado", "Imagem da licença sanitária");
			}
		} else {
			if (!UtilsAguaLegal.detectarExtensaoConteudo(dto.getLicencaVigilancia().getImagem()).equals("IMAGEM")) {
				errors.addError("Formato do campo não informado corretamente", "Imagem da licença sanitária");
			} else {
				if (!UtilsAguaLegal.verificaTamanhoImagemValido(dto.getLicencaVigilancia().getImagem(), true)) {
					errors.addError("Tamanho limite de 4 MB ultrapassado", "Imagem da licença sanitária");
				}
			}
		}

		/* Validação feita apenas se o tipo água não for água de sais */
		if (!dto.getTipoAgua().equals("2")) {
			if (!UtilsAguaLegal.isNotEmpty(dto.getLicencaMineracao().getImagem())) {
				if (imagemLicencaMineral != null && imagemLicencaMineral.getCampoObrigatorio() == 'S') {
					errors.addError("Campo não informado", "Imagem da licença de mineração");
				}
			} else {
				if (!UtilsAguaLegal.detectarExtensaoConteudo(dto.getLicencaMineracao().getImagem()).equals("IMAGEM")) {
					errors.addError("Formato do campo não informado corretamente", "Imagem da licença mineração");
				} else {
					if (!UtilsAguaLegal.verificaTamanhoImagemValido(dto.getLicencaMineracao().getImagem(), true)) {
						errors.addError("Tamanho limite de 4 MB ultrapassado", "Imagem da licença de mineração");
					}
				}
			}

			if (UtilsAguaLegal.isEmpty(dto.getLicencaMineracao().getNumero())
					&& (numeroLicencaMineral != null && numeroLicencaMineral.getCampoObrigatorio() == 'S')) {
				errors.addError("Campo não informado", "Número licença mineração");
			}
		}
	}

	private void validaCamposEnderecoEnvase(DadosSolicitacaoDTO dto, ValidationError errors,
			List<CampoFormulario> list) {

		CampoFormulario enderecoEnvasadora = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("ENDERECOENVASADORA")).collect(Collectors.toList())
				.get(0);

		CampoFormulario coordenadasEnvasadora = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("COORDENADASENVASADORA")).collect(Collectors.toList())
				.get(0);

		CampoFormulario enderecoEnvase = list.stream().filter(item -> item.getCodigoCriterio().equals("ENDERECOENVASE"))
				.collect(Collectors.toList()).get(0);

		CampoFormulario coordenadasEnvase = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("COORDENADASENVASE")).collect(Collectors.toList())
				.get(0);

		if (UtilsAguaLegal.isEmpty(dto.getEnderecoDTO().getEnderecoEnvasador())
				&& (enderecoEnvasadora != null && enderecoEnvasadora.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Endereço envasadora");
		}

		if (UtilsAguaLegal.isEmpty(dto.getEnderecoDTO().getCoordenadasEnvasador())
				&& (coordenadasEnvasadora != null && coordenadasEnvasadora.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Coordenadas envasadora");
		}

		if (UtilsAguaLegal.isEmpty(dto.getEnderecoDTO().getEnderecoEnvase())
				&& (enderecoEnvase != null && enderecoEnvase.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Endereço envase");
		}

		if (UtilsAguaLegal.isEmpty(dto.getEnderecoDTO().getCoordenadasEnvase())
				&& (coordenadasEnvase != null && coordenadasEnvase.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Coordenadas envase");
		}

	}

	private void validaCamposResponsavelEnvasadora(DadosSolicitacaoDTO dto, ValidationError errors,
			List<CampoFormulario> list) {

		CampoFormulario campoNomeResponsavel = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("NOMERESPONSAVEL")).collect(Collectors.toList()).get(0);

		CampoFormulario campoEmailResponsavel = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("EMAILRESPONSAVEL")).collect(Collectors.toList())
				.get(0);

		CampoFormulario campoRgResponsavel = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("RGRESPONSAVEL")).collect(Collectors.toList()).get(0);

		CampoFormulario campoCpfResponsavel = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("CPFRESPONSAVEL")).collect(Collectors.toList()).get(0);

		CampoFormulario campoTelefoneResponsavel = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("TELEFONERESPONSAVEL")).collect(Collectors.toList())
				.get(0);

		if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getNomeResponsavel())
				&& (campoNomeResponsavel != null && campoNomeResponsavel.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Nome Responsável");
		}

		if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getCpfResponsavel())) {
			if (campoCpfResponsavel != null && campoCpfResponsavel.getCampoObrigatorio() == 'S') {
				errors.addError("Campo não informado", "CPF Responsável");
			}
		} else {
			if (!UtilsAguaLegal.verificaCpfValido(dto.getResponsavel().getCpfResponsavel())) {
				errors.addError("Conteúdo do campo inválido", "CPF Responsável");
			}
		}

		if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getEmailResponsavel())) {
			if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getEmailResponsavel())
					&& (campoEmailResponsavel != null && campoEmailResponsavel.getCampoObrigatorio() == 'S')) {
				errors.addError("Campo não informado", "Email Responsável");
			}
		} else {
			if (!UtilsAguaLegal.verificaEmailValido(dto.getResponsavel().getEmailResponsavel())) {
				errors.addError("Conteúdo do campo inválido", "Email Responsável");
			}
		}

		if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getRgResponsavel())
				&& (campoRgResponsavel != null && campoRgResponsavel.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "RG Responsável");
		}
		if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getTelefoneResponsavel())
				&& (campoTelefoneResponsavel != null && campoTelefoneResponsavel.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Telefone Responsável");
		}

	}

	private void validaCamposCadastroEnvasadora(DadosSolicitacaoDTO dto, ValidationError errors,
			List<CampoFormulario> list) {

		CampoFormulario campoCnpj = list.stream().filter(item -> item.getCodigoCriterio().equals("CNPJENVASADORA"))
				.collect(Collectors.toList()).get(0);

		CampoFormulario campoRazao = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("RAZAOSOCIALENVASADORA")).collect(Collectors.toList())
				.get(0);

		CampoFormulario campoNomeFantasia = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("NOMEFANTASIAENVASADORA")).collect(Collectors.toList())
				.get(0);

		CampoFormulario campoInscricao = list.stream()
				.filter(item -> item.getCodigoCriterio().equals("INSCRICAOESTADUAL")).collect(Collectors.toList())
				.get(0);

		if (UtilsAguaLegal.isEmpty(dto.getCadastro().getCnpj())) {
			if (campoCnpj != null && campoCnpj.getCampoObrigatorio() == 'S') {
				errors.addError("Campo não informado", "CNPJ envasadora");
			}
		} else {
			if (!UtilsAguaLegal.verificaCnpjValido(dto.getCadastro().getCnpj())) {
				errors.addError("Conteúdo do campo inválido", "CNPJ envasadora");
			}
		}

		if (UtilsAguaLegal.isEmpty(dto.getCadastro().getRazaoSocial())
				&& (campoRazao != null && campoRazao.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Razão Social");
		}
		if (UtilsAguaLegal.isEmpty(dto.getCadastro().getNomeFantasia())
				&& (campoNomeFantasia != null && campoNomeFantasia.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Nome Fantasia");
		}
		if (UtilsAguaLegal.isEmpty(dto.getCadastro().getInscricaoEstadual())
				&& (campoInscricao != null && campoInscricao.getCampoObrigatorio() == 'S')) {
			errors.addError("Campo não informado", "Inscrição Estadual");
		}
	}

	private void validaListaProdutos(List<ProdutoDTO> listaProdutos, ValidationError errors) {
		if (listaProdutos.isEmpty()) {
			errors.addError("A lista de produtos está vazia!", "Lista Produtos");
		}

		/* Verificar campos vazios, formato das imagens e tamanho */
		for (int i = 0; i < listaProdutos.size(); i++) {
			ProdutoDTO produto = listaProdutos.get(i);
			Integer numeroProduto = i + 1;
			if (UtilsAguaLegal.isEmpty(produto.getDescricaoMarca())) {
				errors.addError("Produto - " + numeroProduto, "Descrição da marca ser informada");
			}
			if (produto.getVolume() == null) {
				errors.addError("Produto - " + numeroProduto, "Volume deve ser informado");
			}

			if (produto.getTipoProduto() == null) {
				errors.addError("Produto - " + numeroProduto, "Tipo deve ser informado");
			} else {
				if (produto.getTipoProduto() != 1 && produto.getTipoProduto() != 2) {
					errors.addError("Produto - " + numeroProduto, "Código referente ao tipo de produto inválido");
				}
			}

			if (produto.getTipoEmbalagem() == null) {
				errors.addError("Produto - " + numeroProduto, "Tipo de embalagem deve ser informado");
			} else {
				if (produto.getTipoEmbalagem() != 1 && produto.getTipoEmbalagem() != 2) {
					errors.addError("Produto - " + numeroProduto, "Código referente ao tipo de embalagem inválido");
				}
			}

			if (!UtilsAguaLegal.isNotEmpty(produto.getImagemRecipiente())) {
				errors.addError("Produto - " + numeroProduto, "Foto do recipiente deve ser informada");
			} else {
				if (!UtilsAguaLegal.isImage(produto.getImagemRecipiente())) {
					errors.addError("Produto - " + numeroProduto,
							"O arquivo referente ao recipiente deve ser uma imagem");
				} else {
					if (!UtilsAguaLegal.verificaTamanhoImagemValido(produto.getImagemRecipiente(), false)) {
						errors.addError("Produto - " + numeroProduto,
								"O arquivo referente ao recipiente excedeu o tamanho definido de 2MB");
					}
				}
			}

			if (!UtilsAguaLegal.isNotEmpty(produto.getImagemRotulo())) {
				errors.addError("Produto - " + numeroProduto, "Imagem do rótulo deve ser informada");
			} else {
				if (!UtilsAguaLegal.isImage(produto.getImagemRotulo())) {
					errors.addError("Produto - " + numeroProduto, "O arquivo referente ao rótulo deve ser uma imagem");
				} else {
					if (!UtilsAguaLegal.verificaTamanhoImagemValido(produto.getImagemRotulo(), false)) {
						errors.addError("Produto - " + numeroProduto,
								"O arquivo referente ao rótulo excedeu o tamanho definido de 2MB");
					}
				}
			}

		}
	}
}