package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class ProdutoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String descricaoMarca;

	private byte[] imagemRecipiente;

	private byte[] imagemRotulo;

	private Integer tipoEmbalagem;

	private Integer tipoProduto;

	private Integer volume;

	public String getDescricaoMarca() {
		return descricaoMarca;
	}

	public void setDescricaoMarca(String descricaoMarca) {
		this.descricaoMarca = descricaoMarca;
	}

	public byte[] getImagemRecipiente() {
		return imagemRecipiente;
	}

	public void setImagemRecipiente(byte[] imagemRecipiente) {
		this.imagemRecipiente = imagemRecipiente;
	}

	public byte[] getImagemRotulo() {
		return imagemRotulo;
	}

	public void setImagemRotulo(byte[] imagemRotulo) {
		this.imagemRotulo = imagemRotulo;
	}

	public Integer getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(Integer tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	public Integer getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(Integer tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "ProdutoDTO [descricaoMarca=" + descricaoMarca + ", imagemRecipiente="
				+ Arrays.toString(imagemRecipiente) + ", imagemRotulo=" + Arrays.toString(imagemRotulo)
				+ ", tipoEmbalagem=" + tipoEmbalagem + ", tipoProduto=" + tipoProduto + ", volume=" + volume + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imagemRecipiente);
		result = prime * result + Arrays.hashCode(imagemRotulo);
		result = prime * result + Objects.hash(descricaoMarca, tipoEmbalagem, tipoProduto, volume);
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
				&& Arrays.equals(imagemRecipiente, other.imagemRecipiente)
				&& Arrays.equals(imagemRotulo, other.imagemRotulo) && Objects.equals(tipoEmbalagem, other.tipoEmbalagem)
				&& Objects.equals(tipoProduto, other.tipoProduto) && Objects.equals(volume, other.volume);
	}

}
