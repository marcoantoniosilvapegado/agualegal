package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class ProdutoSolicitacaoDTO implements Serializable {

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

	@NotBlank(message = "É obrigatório informar a imagem do rótulo!")
	private String imagemRotuloBase64;

	@NotBlank(message = "É obrigatório informar a foto do recipiente!")
	private String fotoRecipienteBase64;

	public ProdutoSolicitacaoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoSolicitacaoDTO(
			@NotBlank(message = "É obrigatório informar a descrição da marca!") String descricaoMarca,
			@NotBlank(message = "É obrigatório informar o tipo do produto!") String tipo,
			@NotBlank(message = "É obrigatório informar o volume!") String volume,
			@NotBlank(message = "É obrigatório informar tipo de embalagem!") String tipoEmbalagem,
			@NotBlank(message = "É obrigatório informar a imagem do rótulo!") String imagemRotuloBase64,
			@NotBlank(message = "É obrigatório informar a foto do recipiente!") String fotoRecipienteBase64) {
		super();
		this.descricaoMarca = descricaoMarca;
		this.tipo = tipo;
		this.volume = volume;
		this.tipoEmbalagem = tipoEmbalagem;
		this.imagemRotuloBase64 = imagemRotuloBase64;
		this.fotoRecipienteBase64 = fotoRecipienteBase64;
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

	public String getImagemRotuloBase64() {
		return imagemRotuloBase64;
	}

	public void setImagemRotuloBase64(String imagemRotuloBase64) {
		this.imagemRotuloBase64 = imagemRotuloBase64;
	}

	public String getFotoRecipienteBase64() {
		return fotoRecipienteBase64;
	}

	public void setFotoRecipienteBase64(String fotoRecipienteBase64) {
		this.fotoRecipienteBase64 = fotoRecipienteBase64;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoMarca, fotoRecipienteBase64, imagemRotuloBase64, tipo, tipoEmbalagem, volume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoSolicitacaoDTO other = (ProdutoSolicitacaoDTO) obj;
		return Objects.equals(descricaoMarca, other.descricaoMarca)
				&& Objects.equals(fotoRecipienteBase64, other.fotoRecipienteBase64)
				&& Objects.equals(imagemRotuloBase64, other.imagemRotuloBase64) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(tipoEmbalagem, other.tipoEmbalagem) && Objects.equals(volume, other.volume);
	}

	@Override
	public String toString() {
		return "ProdutoSolicitacaoDTO [descricaoMarca=" + descricaoMarca + ", tipo=" + tipo + ", volume=" + volume
				+ ", tipoEmbalagem=" + tipoEmbalagem + ", imagemRotuloBase64=" + imagemRotuloBase64
				+ ", fotoRecipienteBase64=" + fotoRecipienteBase64 + "]";
	}

}
