package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SolicitacaoCredenciamentoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "É obrigatório informar o token!")
	private String tokenGrafica;

	@NotBlank(message = "É obrigatório informar a inscrição estadual!")
	private String inscricaoEstadual;

	@NotBlank(message = "É obrigatório informar o tipo da água!")
	@Pattern(regexp = "1|2|3", message = "O tipo da água deve ser 1(Adicionada de sais), 2(mineral) ou 3(ambas)!")
	private String tipoAgua;

	@NotNull(message = "É obrigatório informar a lista de campos!")
	@NotEmpty(message = "A lista de campos informada está vazia!")
	@Valid
	private List<CampoDTO> listaCampos = new ArrayList<CampoDTO>();
	
	@NotNull(message = "É obrigatório informar a lista de produtos!")
	@NotEmpty(message = "A lista de produtos informada está vazia!")
	@Valid
	private List<ProdutoSolicitacaoDTO> listaProdutos = new ArrayList<ProdutoSolicitacaoDTO>();

	public String getTokenGrafica() {
		return tokenGrafica;
	}

	public void setTokenGrafica(String tokenGrafica) {
		this.tokenGrafica = tokenGrafica;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getTipoAgua() {
		return tipoAgua;
	}

	public void setTipoAgua(String tipoAgua) {
		this.tipoAgua = tipoAgua;
	}

	public List<CampoDTO> getListaCampos() {
		return listaCampos;
	}

	public void setListaCampos(List<CampoDTO> listaCampos) {
		this.listaCampos = listaCampos;
	}

	public List<ProdutoSolicitacaoDTO> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutoSolicitacaoDTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inscricaoEstadual, listaCampos, listaProdutos, tipoAgua, tokenGrafica);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolicitacaoCredenciamentoDTO other = (SolicitacaoCredenciamentoDTO) obj;
		return Objects.equals(inscricaoEstadual, other.inscricaoEstadual)
				&& Objects.equals(listaCampos, other.listaCampos) && Objects.equals(listaProdutos, other.listaProdutos)
				&& Objects.equals(tipoAgua, other.tipoAgua) && Objects.equals(tokenGrafica, other.tokenGrafica);
	}

	@Override
	public String toString() {
		return "SolicitacaoCredenciamentoDTO [tokenGrafica=" + tokenGrafica + ", inscricaoEstadual=" + inscricaoEstadual
				+ ", tipoAgua=" + tipoAgua + ", listaCampos=" + listaCampos + ", listaProdutos=" + listaProdutos + "]";
	}

}
