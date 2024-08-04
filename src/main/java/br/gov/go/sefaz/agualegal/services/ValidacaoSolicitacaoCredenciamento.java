package br.gov.go.sefaz.agualegal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.exception.ValidacaoSolicitacaoException;
import br.gov.go.sefaz.agualegal.exception.ValidationError;
import br.gov.go.sefaz.agualegal.modelo.CampoFormulario;
import br.gov.go.sefaz.agualegal.repository.CampoFormularioRepository;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

//@Service
public class ValidacaoSolicitacaoCredenciamento {

	private CampoFormularioRepository campoFormularioRepository;

	public ValidacaoSolicitacaoCredenciamento(CampoFormularioRepository campoFormularioRepository) {
		this.campoFormularioRepository = campoFormularioRepository;
	}
	
	public void validacaoDadosSolicitacaoCredenciamento(DadosSolicitacaoDTO dto) {
		
	}

	public void validacaoDadosSolicitacaoCredenciamento2(DadosSolicitacaoDTO dto) {
		ValidationError errors = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
				System.currentTimeMillis());

		/* Inicializa lista de validações */
		errors.setList(new ArrayList<>());
	
		/* Validação dos campos obrigatórios */

		this.validaCamposFormulario(dto, errors);

		if (errors.hasErrors()) {
			throw new ValidacaoSolicitacaoException(errors);
		}
	}

	private void validaCamposFormulario(DadosSolicitacaoDTO dto, ValidationError errors) {

		/**/
		List<CampoFormulario> list = null;//this.campoFormularioRepository.findCamposAtivosFormulario().get();

		this.validaCamposCadastroEnvasadora(dto, errors, list);
		this.validaCamposResponsavelEnvasadora(dto, errors, list);
		this.validaCamposEnderecoEnvase(dto, errors, list);
		this.validaLicencas(dto, errors, list);

		CampoFormulario observacao = list.stream().filter(item -> item.getId().equals(20L)).collect(Collectors.toList())
				.get(0);

		if (UtilsAguaLegal.isEmpty(dto.getObservacao())
				&& (observacao != null && observacao.getCampoObrigatorio().equals("S"))) {
			errors.addError("Campo não informado", "Observação");
		}

	}

	private void validaLicencas(DadosSolicitacaoDTO dto, ValidationError errors, List<CampoFormulario> list) {

		CampoFormulario emissorLicencaVigilancia = list.stream().filter(item -> item.getId().equals(10L))
				.collect(Collectors.toList()).get(0);

		CampoFormulario imagemLicencaVigilancia = list.stream().filter(item -> item.getId().equals(11L))
				.collect(Collectors.toList()).get(0);

		CampoFormulario numeroLicencaVigilancia = list.stream().filter(item -> item.getId().equals(12L))
				.collect(Collectors.toList()).get(0);

		CampoFormulario imagemLicencaMineral = list.stream().filter(item -> item.getId().equals(13L))
				.collect(Collectors.toList()).get(0);

		CampoFormulario numeroLicencaMineral = list.stream().filter(item -> item.getId().equals(14L))
				.collect(Collectors.toList()).get(0);

	/*	if (UtilsAguaLegal.isEmpty(dto.getLicencaVigilancia().getEmissor())
				&& (emissorLicencaVigilancia != null && emissorLicencaVigilancia.getCampoObrigatorio().equals("S"))) {
			errors.addError("Campo não informado", "Emissor licença sanitária");
		}*/

		if (UtilsAguaLegal.isEmpty(dto.getLicencaVigilancia().getNumero())
				&& (numeroLicencaVigilancia != null && numeroLicencaVigilancia.getCampoObrigatorio().equals("S"))) {
			errors.addError("Campo não informado", "Número licença sanitária");
		}

		if (!UtilsAguaLegal.isNotEmpty(dto.getLicencaVigilancia().getImagem())) {
			if (imagemLicencaVigilancia != null && imagemLicencaVigilancia.getCampoObrigatorio().equals("S")) {
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

		/*
		 * se for tipo 1(água de sais) não é validado licença da agência nacional de
		 * mineração
		 */
		if (!dto.getTipoAgua().equals("1")) {
			/* Validar imagem da licença da agência nacional de mineração */
			if (!UtilsAguaLegal.isNotEmpty(dto.getLicencaMineracao().getImagem())) {
				if (imagemLicencaMineral != null && imagemLicencaMineral.getCampoObrigatorio().equals("S")) {
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

			/* Validar número da licença da agência nacional de mineração */
			if (UtilsAguaLegal.isEmpty(dto.getLicencaMineracao().getNumero())
					&& (numeroLicencaMineral != null && numeroLicencaMineral.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "Número licença mineração");
			}

		}

	}

	private void validaCamposEnderecoEnvase(DadosSolicitacaoDTO dto, ValidationError errors,
			List<CampoFormulario> list) {

		CampoFormulario enderecoEnvasadora = list.stream().filter(item -> item.getId().equals(15L))
				.collect(Collectors.toList()).get(0);

		CampoFormulario coordenadasEnvasadora = list.stream().filter(item -> item.getId().equals(16L))
				.collect(Collectors.toList()).get(0);

		CampoFormulario enderecoEnvase = list.stream().filter(item -> item.getId().equals(17L))
				.collect(Collectors.toList()).get(0);

		CampoFormulario coordenadasEnvase = list.stream().filter(item -> item.getId().equals(18L))
				.collect(Collectors.toList()).get(0);

		/*if (UtilsAguaLegal.isEmpty(dto.getEnderecoEnvasador())
				&& (enderecoEnvasadora != null && enderecoEnvasadora.getCampoObrigatorio().equals("S"))) {
			errors.addError("Campo não informado", "Endereço envasadora");
		}

		if (UtilsAguaLegal.isEmpty(dto.getCoordenadasEnvasador())
				&& (coordenadasEnvasadora != null && coordenadasEnvasadora.getCampoObrigatorio().equals("S"))) {
			errors.addError("Campo não informado", "Coordenadas envasadora");
		}

		if (UtilsAguaLegal.isEmpty(dto.getEnderecoEnvase())
				&& (enderecoEnvase != null && enderecoEnvase.getCampoObrigatorio().equals("S"))) {
			errors.addError("Campo não informado", "Endereço envase");
		}

		if (UtilsAguaLegal.isEmpty(dto.getCoordenadasEnvase())
				&& (coordenadasEnvase != null && coordenadasEnvase.getCampoObrigatorio().equals("S"))) {
			errors.addError("Campo não informado", "Coordenadas envase");
		}*/

	}

	private void validaCamposResponsavelEnvasadora(DadosSolicitacaoDTO dto, ValidationError errors,
			List<CampoFormulario> list) {

		if (dto.getResponsavel() != null) {
			CampoFormulario campoNomeResponsavel = list.stream().filter(item -> item.getId().equals(5L))
					.collect(Collectors.toList()).get(0);

			CampoFormulario campoEmailResponsavel = list.stream().filter(item -> item.getId().equals(6L))
					.collect(Collectors.toList()).get(0);

			CampoFormulario campoRgResponsavel = list.stream().filter(item -> item.getId().equals(7L))
					.collect(Collectors.toList()).get(0);

			CampoFormulario campoCpfResponsavel = list.stream().filter(item -> item.getId().equals(8L))
					.collect(Collectors.toList()).get(0);

			CampoFormulario campoTelefoneResponsavel = list.stream().filter(item -> item.getId().equals(9L))
					.collect(Collectors.toList()).get(0);

			if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getNomeResponsavel())
					&& (campoNomeResponsavel != null && campoNomeResponsavel.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "Nome Responsável");
			}
			if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getCpfResponsavel())
					&& (campoCpfResponsavel != null && campoCpfResponsavel.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "CPF Responsável");
			}
			if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getEmailResponsavel())
					&& (campoEmailResponsavel != null && campoEmailResponsavel.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "Email Responsável");
			}
			if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getRgResponsavel())
					&& (campoRgResponsavel != null && campoRgResponsavel.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "RG Responsável");
			}
			if (UtilsAguaLegal.isEmpty(dto.getResponsavel().getTelefoneResponsavel())
					&& (campoTelefoneResponsavel != null
							&& campoTelefoneResponsavel.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "Telefone Responsável");
			}
		} else {
			errors.addError("Campo não informado", "Favor informar os campos referentes ao responsável!");
		}

	}

	private void validaCamposCadastroEnvasadora(DadosSolicitacaoDTO dto, ValidationError errors,
			List<CampoFormulario> list) {

		if (dto.getCadastro() != null) {
			CampoFormulario campoCnpj = list.stream().filter(item -> item.getId().equals(1L))
					.collect(Collectors.toList()).get(0);
			CampoFormulario campoRazao = list.stream().filter(item -> item.getId().equals(2L))
					.collect(Collectors.toList()).get(0);
			CampoFormulario campoNomeFantasia = list.stream().filter(item -> item.getId().equals(3L))
					.collect(Collectors.toList()).get(0);
			CampoFormulario campoInscricao = list.stream().filter(item -> item.getId().equals(4L))
					.collect(Collectors.toList()).get(0);

			if (UtilsAguaLegal.isEmpty(dto.getCadastro().getCnpj())
					&& (campoCnpj != null && campoCnpj.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "CNPJ");
			}
			if (UtilsAguaLegal.isEmpty(dto.getCadastro().getRazaoSocial())
					&& (campoRazao != null && campoRazao.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "Razão Social");
			}
			if (UtilsAguaLegal.isEmpty(dto.getCadastro().getNomeFantasia())
					&& (campoNomeFantasia != null && campoNomeFantasia.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "Nome Fantasia");
			}
			if (UtilsAguaLegal.isEmpty(dto.getCadastro().getInscricaoEstadual())
					&& (campoInscricao != null && campoInscricao.getCampoObrigatorio().equals("S"))) {
				errors.addError("Campo não informado", "Inscrição Estadual");
			}
		} else {
			errors.addError("Campo não informado", "Favor informar os campos cadastrais da envasadora!");
		}

	}

}
