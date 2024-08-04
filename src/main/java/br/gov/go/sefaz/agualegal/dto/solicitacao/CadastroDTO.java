package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.Objects;

public class CadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cnpj;

	private String razaoSocial;

	private String nomeFantasia;

	private String inscricaoEstadual;

	public CadastroDTO() {
		super();
	}

	public CadastroDTO(String cnpj, String razaoSocial, String nomeFantasia, String inscricaoEstadual) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.inscricaoEstadual = inscricaoEstadual;
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

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	@Override
	public String toString() {
		return "CadastroEnvasadoraDTO [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ ", inscricaoEstadual=" + inscricaoEstadual + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, inscricaoEstadual, nomeFantasia, razaoSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroDTO other = (CadastroDTO) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(inscricaoEstadual, other.inscricaoEstadual)
				&& Objects.equals(nomeFantasia, other.nomeFantasia) && Objects.equals(razaoSocial, other.razaoSocial);
	}

}
