package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Pattern;

import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

public class ResponsavelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeResponsavel;

	private String emailResponsavel;

	private String rgResponsavel;

	private String cpfResponsavel;

	private String telefoneResponsavel;

	public ResponsavelDTO() {
		super();
	}

	public ResponsavelDTO(String nomeResponsavel, String emailResponsavel, String rgResponsavel, String cpfResponsavel,
			String telefoneResponsavel) {
		super();
		this.nomeResponsavel = nomeResponsavel;
		this.emailResponsavel = emailResponsavel;
		this.rgResponsavel = rgResponsavel;
		this.cpfResponsavel = cpfResponsavel;
		this.telefoneResponsavel = telefoneResponsavel;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getRgResponsavel() {
		return rgResponsavel;
	}

	public void setRgResponsavel(String rgResponsavel) {
		this.rgResponsavel = rgResponsavel;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}

	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}

	@Override
	public String toString() {
		return "ResponsavelDTO [nomeResponsavel=" + nomeResponsavel + ", emailResponsavel=" + emailResponsavel
				+ ", rgResponsavel=" + rgResponsavel + ", cpfResponsavel=" + cpfResponsavel + ", telefoneResponsavel="
				+ telefoneResponsavel + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfResponsavel, emailResponsavel, nomeResponsavel, rgResponsavel, telefoneResponsavel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsavelDTO other = (ResponsavelDTO) obj;
		return Objects.equals(cpfResponsavel, other.cpfResponsavel)
				&& Objects.equals(emailResponsavel, other.emailResponsavel)
				&& Objects.equals(nomeResponsavel, other.nomeResponsavel)
				&& Objects.equals(rgResponsavel, other.rgResponsavel)
				&& Objects.equals(telefoneResponsavel, other.telefoneResponsavel);
	}
	
	public Boolean isResponsavelVazio() {
		return UtilsAguaLegal.isEmpty(this.cpfResponsavel) && UtilsAguaLegal.isEmpty(this.nomeResponsavel);
	}

}
