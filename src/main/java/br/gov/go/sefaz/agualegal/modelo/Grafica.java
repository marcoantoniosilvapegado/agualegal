package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TAB_GRAFICA", uniqueConstraints = { @UniqueConstraint(columnNames = { "cnpj", "razao_social" }) })
public class Grafica {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grafica")
	@SequenceGenerator(name = "seq_grafica", sequenceName = "seq_tab_grafica", allocationSize = 1)
	@Column(name = "id_grafica")
	private Integer idGrafica;

	@Column(name = "cnpj", nullable = false, length = 14)
	private String cnpj;

	@Column(name = "razao_social", nullable = false, length = 200)
	private String razaoSocial;

	@Column(name = "nome_fantasia", nullable = false, length = 200)
	private String nomeFantasia;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "TELEFONE", length = 20)
	private String telefone;

	@Column(name = "INSCRICAO_ESTADUAL", length = 20)
	private String inscricaoEstadual;

	@Column(name = "CEP", length = 8)
	private String cep;

	@Column(name = "LOGRADOURO", length = 50)
	private String logradouro;

	@Column(name = "NUMERO", length = 5)
	private String numero;

	@Column(name = "COMPLEMENTO", length = 100)
	private String complemento;

	@Column(name = "BAIRRO", length = 50)
	private String bairro;

	@Column(name = "CIDADE", length = 50)
	private String cidade;

	@Column(name = "UF", length = 2)
	private String uf;

	@Column(name = "TOKEN", length = 50)
	private String token;

	public Grafica() {
		// TODO Auto-generated constructor stub
	}

	public Grafica(Integer idGrafica, String cnpj, String razaoSocial, String nomeFantasia, String email,
			String telefone, String inscricaoEstadual, String cep, String logradouro, String numero, String complemento,
			String bairro, String cidade, String uf, String token) {
		super();
		this.idGrafica = idGrafica;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.email = email;
		this.telefone = telefone;
		this.inscricaoEstadual = inscricaoEstadual;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.token = token;
	}

	public Integer getIdGrafica() {
		return idGrafica;
	}

	public void setIdGrafica(Integer idGrafica) {
		this.idGrafica = idGrafica;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Grafica [idGrafica=" + idGrafica + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia="
				+ nomeFantasia + ", email=" + email + ", telefone=" + telefone + ", inscricaoEstadual="
				+ inscricaoEstadual + ", cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf
				+ ", token=" + token + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, cnpj, complemento, email, idGrafica, inscricaoEstadual, logradouro,
				nomeFantasia, numero, razaoSocial, telefone, token, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grafica other = (Grafica) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(email, other.email)
				&& Objects.equals(idGrafica, other.idGrafica)
				&& Objects.equals(inscricaoEstadual, other.inscricaoEstadual)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nomeFantasia, other.nomeFantasia)
				&& Objects.equals(numero, other.numero) && Objects.equals(razaoSocial, other.razaoSocial)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(token, other.token)
				&& Objects.equals(uf, other.uf);
	}

}
