package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAB_PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	@SequenceGenerator(name = "seq_produto", sequenceName = "seq_tab_produto", allocationSize = 1)
	@Column(name = "id_produto")
	private Integer idProduto;

	@Column(name = "descricao_marca", nullable = false, length = 200)
	private String descricaoMarca;

	@Lob
	@Column(name = "imagem_recipiente", nullable = false)
	private String imagemRecipiente;

	@Lob
	@Column(name = "imagem_rotulo", nullable = false)
	private String imagemRotulo;

	@ManyToOne
	@JoinColumn(name = "id_tipo_embalagem", nullable = false)
	private TipoEmbalagem tipoEmbalagem;

	@ManyToOne
	@JoinColumn(name = "id_tipo_produto", nullable = false)
	private TipoAgua tipoProduto;

	@ManyToOne
	@JoinColumn(name = "id_envasadora", nullable = false)
	private Envasadora envasadora;

	@Column(name = "status", length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
	private Character status;

	@Column(name = "volume", nullable = false)
	private Integer volume;

	public Produto() {
	
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricaoMarca() {
		return descricaoMarca;
	}

	public void setDescricaoMarca(String descricaoMarca) {
		this.descricaoMarca = descricaoMarca;
	}

	public String getImagemRecipiente() {
		return imagemRecipiente;
	}

	public void setImagemRecipiente(String imagemRecipiente) {
		this.imagemRecipiente = imagemRecipiente;
	}

	public String getImagemRotulo() {
		return imagemRotulo;
	}

	public void setImagemRotulo(String imagemRotulo) {
		this.imagemRotulo = imagemRotulo;
	}

	public TipoEmbalagem getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(TipoEmbalagem tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	public TipoAgua getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoAgua tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Envasadora getEnvasadora() {
		return envasadora;
	}

	public void setEnvasadora(Envasadora envasadora) {
		this.envasadora = envasadora;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricaoMarca=" + descricaoMarca + ", imagemRecipiente="
				+ imagemRecipiente + ", imagemRotulo=" + imagemRotulo + ", tipoEmbalagem=" + tipoEmbalagem
				+ ", tipoProduto=" + tipoProduto + ", envasadora=" + envasadora + ", status=" + status + ", volume="
				+ volume + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoMarca, envasadora, idProduto, imagemRecipiente, imagemRotulo, status,
				tipoEmbalagem, tipoProduto, volume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descricaoMarca, other.descricaoMarca) && Objects.equals(envasadora, other.envasadora)
				&& Objects.equals(idProduto, other.idProduto)
				&& Objects.equals(imagemRecipiente, other.imagemRecipiente)
				&& Objects.equals(imagemRotulo, other.imagemRotulo) && Objects.equals(status, other.status)
				&& Objects.equals(tipoEmbalagem, other.tipoEmbalagem) && Objects.equals(tipoProduto, other.tipoProduto)
				&& Objects.equals(volume, other.volume);
	}

}