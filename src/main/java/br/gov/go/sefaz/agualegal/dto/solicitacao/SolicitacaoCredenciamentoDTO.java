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

	@NotNull(message = "É obrigatório informar a lista de arquivos!")
	@NotEmpty(message = "A lista de arquivos informada está vazia!")
	@Valid
	private List<ArquivoDTO> listaArquivos = new ArrayList<ArquivoDTO>();

	@NotNull(message = "É obrigatório informar a lista de produtos!")
	@NotEmpty(message = "A lista de produtos informada está vazia!")
	@Valid
	private List<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();

	public SolicitacaoCredenciamentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitacaoCredenciamentoDTO(@NotBlank(message = "É obrigatório informar o token!") String tokenGrafica,
			@NotBlank(message = "É obrigatório informar a inscrição estadual!") String inscricaoEstadual,
			@NotBlank(message = "É obrigatório informar o tipo da água!") @Pattern(regexp = "1|2|3", message = "O tipo da água deve ser 1(Adicionada de sais), 2(mineral) ou 3(ambas)!") String tipoAgua,
			@NotNull(message = "É obrigatório informar a lista de campos!") @NotEmpty(message = "A lista de campos informada está vazia!") @Valid List<CampoDTO> listaCampos,
			@NotNull(message = "É obrigatório informar a lista de arquivos!") @NotEmpty(message = "A lista de arquivos informada está vazia!") @Valid List<ArquivoDTO> listaArquivos,
			@NotNull(message = "É obrigatório informar a lista de produtos!") @NotEmpty(message = "A lista de produtos informada está vazia!") @Valid List<ProdutoDTO> listaProdutos) {
		super();
		this.tokenGrafica = tokenGrafica;
		this.inscricaoEstadual = inscricaoEstadual;
		this.tipoAgua = tipoAgua;
		this.listaCampos = listaCampos;
		this.listaArquivos = listaArquivos;
		this.listaProdutos = listaProdutos;
	}

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

	public List<ArquivoDTO> getListaArquivos() {
		return listaArquivos;
	}

	public void setListaArquivos(List<ArquivoDTO> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}

	public List<ProdutoDTO> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutoDTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inscricaoEstadual, listaArquivos, listaCampos, listaProdutos, tipoAgua, tokenGrafica);
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
				&& Objects.equals(listaArquivos, other.listaArquivos) && Objects.equals(listaCampos, other.listaCampos)
				&& Objects.equals(listaProdutos, other.listaProdutos) && Objects.equals(tipoAgua, other.tipoAgua)
				&& Objects.equals(tokenGrafica, other.tokenGrafica);
	}

	@Override
	public String toString() {
		return "SolicitacaoCredenciamentoDTO [tokenGrafica=" + tokenGrafica + ", inscricaoEstadual=" + inscricaoEstadual
				+ ", tipoAgua=" + tipoAgua + ", listaCampos=" + listaCampos + ", listaArquivos=" + listaArquivos
				+ ", listaProdutos=" + listaProdutos + "]";
	}

}
