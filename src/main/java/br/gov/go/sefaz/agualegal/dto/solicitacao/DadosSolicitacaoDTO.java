package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class DadosSolicitacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CadastroDTO cadastro = new CadastroDTO();

	private ResponsavelDTO responsavel = new ResponsavelDTO();

	private LicencaDTO licencaVigilancia = new LicencaDTO();

	private LicencaDTO licencaMineracao= new LicencaDTO();

	private EnderecoDTO enderecoDTO = new EnderecoDTO();

	private List<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();

	@NotBlank(message = "É obrigatório informar o tipo da água!")
	@Pattern(regexp = "1|2|3", message = "O tipo da água deve ser 1(Adicionada de sais), 2(mineral) ou 3(ambas)!")
	private String tipoAgua;

	private String observacao;

	@NotBlank(message = "É obrigatório informar o token da gráfica!")
	private String tokenGrafica;

	@NotBlank(message = "É obrigatório informar o cnpj da gráfica!")
	private String cnpjGrafica;

	public DadosSolicitacaoDTO() {
		super();

	}

	public DadosSolicitacaoDTO(CadastroDTO cadastro, ResponsavelDTO responsavel, LicencaDTO licencaVigilancia,
			LicencaDTO licencaMineracao, EnderecoDTO enderecoDTO, List<ProdutoDTO> listaProdutos,
			@NotBlank(message = "É obrigatório informar o tipo da água!") @Pattern(regexp = "1|2|3", message = "O tipo da água deve ser 1(Adicionada de sais), 2(mineral) ou 3(ambas)!") String tipoAgua,
			String observacao, String tokenGrafica, String cnpjGrafica) {
		super();
		this.cadastro = cadastro;
		this.responsavel = responsavel;
		this.licencaVigilancia = licencaVigilancia;
		this.licencaMineracao = licencaMineracao;
		this.enderecoDTO = enderecoDTO;
		this.listaProdutos = listaProdutos;
		this.tipoAgua = tipoAgua;
		this.observacao = observacao;
		this.tokenGrafica = tokenGrafica;
		this.cnpjGrafica = cnpjGrafica;
	}
	
	public List<LicencaDTO> getListaLicencas(){
		List<LicencaDTO> lista = new ArrayList<>();
		
		if(!this.licencaVigilancia.registroVazio()) {
			licencaVigilancia.setIsLicencaSanitaria(true);
			lista.add(licencaVigilancia);
		}
		if(!this.licencaMineracao.registroVazio()) {
			licencaMineracao.setIsLicencaSanitaria(false);
			lista.add(licencaMineracao);
		}
		return lista;
	}

	public CadastroDTO getCadastro() {
		return cadastro;
	}

	public void setCadastro(CadastroDTO cadastro) {
		this.cadastro = cadastro;
	}

	public ResponsavelDTO getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelDTO responsavel) {
		this.responsavel = responsavel;
	}

	public LicencaDTO getLicencaVigilancia() {
		return licencaVigilancia;
	}

	public void setLicencaVigilancia(LicencaDTO licencaVigilancia) {
		this.licencaVigilancia = licencaVigilancia;
	}

	public LicencaDTO getLicencaMineracao() {
		return licencaMineracao;
	}

	public void setLicencaMineracao(LicencaDTO licencaMineracao) {
		this.licencaMineracao = licencaMineracao;
	}

	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}

	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}

	public List<ProdutoDTO> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutoDTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public String getTipoAgua() {
		return tipoAgua;
	}

	public void setTipoAgua(String tipoAgua) {
		this.tipoAgua = tipoAgua;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTokenGrafica() {
		return tokenGrafica;
	}

	public void setTokenGrafica(String tokenGrafica) {
		this.tokenGrafica = tokenGrafica;
	}

	public String getCnpjGrafica() {
		return cnpjGrafica;
	}

	public void setCnpjGrafica(String cnpjGrafica) {
		this.cnpjGrafica = cnpjGrafica;
	}

	@Override
	public String toString() {
		return "DadosSolicitacaoDTO [cadastro=" + cadastro + ", responsavel=" + responsavel + ", licencaVigilancia="
				+ licencaVigilancia + ", licencaMineracao=" + licencaMineracao + ", enderecoDTO=" + enderecoDTO
				+ ", listaProdutos=" + listaProdutos + ", tipoAgua=" + tipoAgua + ", observacao=" + observacao
				+ ", tokenGrafica=" + tokenGrafica + ", cnpjGrafica=" + cnpjGrafica + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cadastro, cnpjGrafica, enderecoDTO, licencaMineracao, licencaVigilancia, listaProdutos,
				observacao, responsavel, tipoAgua, tokenGrafica);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosSolicitacaoDTO other = (DadosSolicitacaoDTO) obj;
		return Objects.equals(cadastro, other.cadastro) && Objects.equals(cnpjGrafica, other.cnpjGrafica)
				&& Objects.equals(enderecoDTO, other.enderecoDTO)
				&& Objects.equals(licencaMineracao, other.licencaMineracao)
				&& Objects.equals(licencaVigilancia, other.licencaVigilancia)
				&& Objects.equals(listaProdutos, other.listaProdutos) && Objects.equals(observacao, other.observacao)
				&& Objects.equals(responsavel, other.responsavel) && Objects.equals(tipoAgua, other.tipoAgua)
				&& Objects.equals(tokenGrafica, other.tokenGrafica);
	}

}
