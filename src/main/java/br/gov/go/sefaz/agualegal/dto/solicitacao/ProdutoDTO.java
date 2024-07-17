package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProdutoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "É obrigatório informar a descrição da marca!")
	private String descricaoMarca;

	@NotBlank(message = "É obrigatório informar o tipo do produto!")
	private String tipo;

	@NotBlank(message = "É obrigatório informar o volume!")
	private String volume;

	@NotBlank(message = "É obrigatório informar tipo de embalagem!")
	private String tipoEmbalagem;

	@NotNull(message = "É obrigatório informar a imagem do rótulo!")
	private byte[] imagemRotuloBase;

	@NotNull(message = "É obrigatório informar a foto do recipiente!")
	private byte[] fotoRecipienteBase;

	public ProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricaoMarca() {
		return descricaoMarca;
	}

	public void setDescricaoMarca(String descricaoMarca) {
		this.descricaoMarca = descricaoMarca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(String tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	public byte[] getImagemRotuloBase() {
		return imagemRotuloBase;
	}

	public void setImagemRotuloBase(byte[] imagemRotuloBase) {
		this.imagemRotuloBase = imagemRotuloBase;
	}

	public byte[] getFotoRecipienteBase() {
		return fotoRecipienteBase;
	}

	public void setFotoRecipienteBase(byte[] fotoRecipienteBase) {
		this.fotoRecipienteBase = fotoRecipienteBase;
	}

	public ProdutoDTO(@NotBlank(message = "É obrigatório informar a descrição da marca!") String descricaoMarca,
			@NotBlank(message = "É obrigatório informar o tipo do produto!") String tipo,
			@NotBlank(message = "É obrigatório informar o volume!") String volume,
			@NotBlank(message = "É obrigatório informar tipo de embalagem!") String tipoEmbalagem,
			@NotNull(message = "É obrigatório informar a imagem do rótulo!") byte[] imagemRotuloBase,
			@NotNull(message = "É obrigatório informar a foto do recipiente!") byte[] fotoRecipienteBase) {
		super();
		this.descricaoMarca = descricaoMarca;
		this.tipo = tipo;
		this.volume = volume;
		this.tipoEmbalagem = tipoEmbalagem;
		this.imagemRotuloBase = imagemRotuloBase;
		this.fotoRecipienteBase = fotoRecipienteBase;
	}

	@Override
	public String toString() {
		return "ProdutoDTO [descricaoMarca=" + descricaoMarca + ", tipo=" + tipo + ", volume=" + volume
				+ ", tipoEmbalagem=" + tipoEmbalagem + ", imagemRotuloBase=" + Arrays.toString(imagemRotuloBase)
				+ ", fotoRecipienteBase=" + Arrays.toString(fotoRecipienteBase) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(fotoRecipienteBase);
		result = prime * result + Arrays.hashCode(imagemRotuloBase);
		result = prime * result + Objects.hash(descricaoMarca, tipo, tipoEmbalagem, volume);
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
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(descricaoMarca, other.descricaoMarca)
				&& Arrays.equals(fotoRecipienteBase, other.fotoRecipienteBase)
				&& Arrays.equals(imagemRotuloBase, other.imagemRotuloBase) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(tipoEmbalagem, other.tipoEmbalagem) && Objects.equals(volume, other.volume);
	}

}
