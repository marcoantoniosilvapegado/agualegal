package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;

public class ArquivoDTO implements Serializable {

	/**
	 * \\\
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Favor informar o nome do campo enviado")
	private String nomeCampo;

	@NotBlank(message = "Favor informar o conteudo do campo(PDF ou imagem)")
	private String tipoCampo;

	@NotNull(message = "Favor informar o conteudo do campo enviado")
	private byte[] file;

	public ArquivoDTO(@NotBlank(message = "Favor informar o nome do campo enviado") String nomeCampo,
			@NotBlank(message = "Favor informar o conteudo do campo(PDF ou imagem)") String tipoCampo,
			@NotNull(message = "Favor informar o conteudo do campo enviado") byte[] file) {
		super();
		this.nomeCampo = nomeCampo;
		this.tipoCampo = tipoCampo;
		this.file = file;
	}

	public ArquivoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(file);
		result = prime * result + Objects.hash(nomeCampo, tipoCampo);
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
		ArquivoDTO other = (ArquivoDTO) obj;
		return Arrays.equals(file, other.file) && Objects.equals(nomeCampo, other.nomeCampo)
				&& Objects.equals(tipoCampo, other.tipoCampo);
	}

	@Override
	public String toString() {
		return "ArquivoDTO [nomeCampo=" + nomeCampo + ", tipoCampo=" + tipoCampo + ", file=" + Arrays.toString(file)
				+ "]";
	}

}
