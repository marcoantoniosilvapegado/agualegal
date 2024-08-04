package br.gov.go.sefaz.agualegal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.gov.go.sefaz.agualegal.dto.solicitacao.DadosSolicitacaoDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;
import br.gov.go.sefaz.agualegal.exception.ValidacaoSolicitacaoException;
import br.gov.go.sefaz.agualegal.exception.ValidationError;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

@Service
public class ValidacaoSolicitacaoCredenciamentoNew {

	public void validacaoDadosSolicitacaoCredenciamento(DadosSolicitacaoDTO dto) {
		
		ValidationError errors = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
				System.currentTimeMillis());

		/* Inicializa lista de validações */
		errors.setList(new ArrayList<>());
		
		/* Inicialmente, será feita validação sob a lista de produtos */
		this.validaListaProdutos(dto.getListaProdutos(), errors);
		
		if (errors.hasErrors()) {
			throw new ValidacaoSolicitacaoException(errors);
		}
	}
	
	private void validaListaProdutos(List<ProdutoDTO> listaProdutos, ValidationError errors) {
		if(listaProdutos.isEmpty()) {
			errors.addError("A lista de produtos está vazia!" , "Lista Produtos");
		}
		
		/* Verificar campos vazios, formato das imagens e tamanho */
		for (int i = 0; i < listaProdutos.size(); i++) {
			ProdutoDTO produto = listaProdutos.get(i);
			Integer numeroProduto = i + 1;
			if (UtilsAguaLegal.isEmpty(produto.getDescricaoMarca())) {
				errors.addError("Produto - " + numeroProduto, "Descrição da marca ser informada");
			}
			if (produto.getVolume()==null) {
				errors.addError("Produto - " + numeroProduto, "Volume deve ser informado");
			}
			
			if (produto.getTipoProduto() == null) {
				errors.addError("Produto - " + numeroProduto, "Tipo deve ser informado");
			}else {
				if(produto.getTipoProduto() != 1 && produto.getTipoProduto() != 2) {
					errors.addError("Produto - " + numeroProduto, "Código referente ao tipo de produto inválido");
				}
			}			
			
			if (produto.getTipoEmbalagem() == null) {
				errors.addError("Produto - " + numeroProduto, "Tipo de embalagem deve ser informado");
			}else {
				if(produto.getTipoEmbalagem() != 1 && produto.getTipoEmbalagem() != 2) {
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
