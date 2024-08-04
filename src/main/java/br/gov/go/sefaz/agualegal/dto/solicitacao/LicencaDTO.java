package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;
import io.swagger.v3.oas.annotations.media.Schema;

public class LicencaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numero;

	private byte[] imagem;

	private Integer emissorLicenca;

	private Boolean isLicencaSanitaria;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Integer getEmissorLicenca() {
		return emissorLicenca;
	}

	public void setEmissorLicenca(Integer emissorLicenca) {
		this.emissorLicenca = emissorLicenca;
	}

	@Override
	public String toString() {
		return "LicencaDTO [numero=" + numero + ", imagem=" + Arrays.toString(imagem) + ", emissorLicenca="
				+ emissorLicenca + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imagem);
		result = prime * result + Objects.hash(emissorLicenca, numero);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LicencaDTO other = (LicencaDTO) obj;
		return Objects.equals(emissorLicenca, other.emissorLicenca) && Arrays.equals(imagem, other.imagem)
				&& Objects.equals(numero, other.numero);
	}

	boolean registroVazio() {
		return this.emissorLicenca == null && this.imagem == null && UtilsAguaLegal.isEmpty(numero);
	}

	public Boolean getIsLicencaSanitaria() {
		return isLicencaSanitaria;
	}

	public void setIsLicencaSanitaria(Boolean isLicencaSanitaria) {
		this.isLicencaSanitaria = isLicencaSanitaria;
	}

}
