package br.gov.go.sefaz.agualegal.modelo;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.go.sefaz.agualegal.dto.solicitacao.ProdutoDTO;

//@Entity
//@Table(name = "TAB_PEDIDO_PRODUTOS")
public class PedidoProduto {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_produto")
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_pedido_credenciamento")
	private PedidoCredenciamento pedidoCredenciamento;

	@Column(name = "descricao_marca", length = 50, nullable = false)
	private String descricaoMarca;

	@Column(name = "tipo_produto", length = 30, nullable = false)
	private String tipoProduto;

	@Column(name = "volume")
	private Integer volume;

	@Column(name = "tipo_embalagem", length = 20, nullable = false)
	private String tipoEmbalagem;

	@Lob
	@Column(name = "imagem_rotulo", nullable = false)
	private byte[] imagemRotulo;

	@Lob
	@Column(name = "imagem_recipiente", nullable = false)
	private byte[] imagemRecipiente;
	
	public PedidoProduto(ProdutoDTO dto, PedidoCredenciamento pedidoCredenciamento) {
		this.pedidoCredenciamento = pedidoCredenciamento;
		
		this.descricaoMarca = dto.getDescricaoMarca();
		this.tipoEmbalagem = dto.getTipoEmbalagem();
		this.tipoProduto = dto.getTipo();
		this.volume =  Integer.parseInt(dto.getVolume());
		
		this.imagemRecipiente = dto.getFotoRecipienteBase();
		this.imagemRotulo = dto.getImagemRotuloBase();
	}
	
	public PedidoProduto() {
		
	}

	public PedidoProduto(Long id, PedidoCredenciamento pedidoCredenciamento, String descricaoMarca, String tipoProduto,
			Integer volume, String tipoEmbalagem, byte[] imagemRotulo, byte[] imagemRecipiente) {
		super();
		this.id = id;
		this.pedidoCredenciamento = pedidoCredenciamento;
		this.descricaoMarca = descricaoMarca;
		this.tipoProduto = tipoProduto;
		this.volume = volume;
		this.tipoEmbalagem = tipoEmbalagem;
		this.imagemRotulo = imagemRotulo;
		this.imagemRecipiente = imagemRecipiente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public PedidoCredenciamento getPedidoCredenciamento() {
		return pedidoCredenciamento;
	}

	public void setPedidoCredenciamento(PedidoCredenciamento pedidoCredenciamento) {
		this.pedidoCredenciamento = pedidoCredenciamento;
	}

	public String getDescricaoMarca() {
		return descricaoMarca;
	}

	public void setDescricaoMarca(String descricaoMarca) {
		this.descricaoMarca = descricaoMarca;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(String tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	public byte[] getImagemRotulo() {
		return imagemRotulo;
	}

	public void setImagemRotulo(byte[] imagemRotulo) {
		this.imagemRotulo = imagemRotulo;
	}

	public byte[] getImagemRecipiente() {
		return imagemRecipiente;
	}

	public void setImagemRecipiente(byte[] imagemRecipiente) {
		this.imagemRecipiente = imagemRecipiente;
	}

	@Override
	public String toString() {
		return "PedidoProduto [id=" + id + ", pedidoCredenciamento=" + pedidoCredenciamento + ", descricaoMarca="
				+ descricaoMarca + ", tipoProduto=" + tipoProduto + ", volume=" + volume + ", tipoEmbalagem="
				+ tipoEmbalagem + ", imagemRotulo=" + Arrays.toString(imagemRotulo) + ", imagemRecipiente="
				+ Arrays.toString(imagemRecipiente) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imagemRecipiente);
		result = prime * result + Arrays.hashCode(imagemRotulo);
		result = prime * result
				+ Objects.hash(descricaoMarca, id, pedidoCredenciamento, tipoEmbalagem, tipoProduto, volume);
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
		PedidoProduto other = (PedidoProduto) obj;
		return Objects.equals(descricaoMarca, other.descricaoMarca) && Objects.equals(id, other.id)
				&& Arrays.equals(imagemRecipiente, other.imagemRecipiente)
				&& Arrays.equals(imagemRotulo, other.imagemRotulo)
				&& Objects.equals(pedidoCredenciamento, other.pedidoCredenciamento)
				&& Objects.equals(tipoEmbalagem, other.tipoEmbalagem) && Objects.equals(tipoProduto, other.tipoProduto)
				&& Objects.equals(volume, other.volume);
	}*/

}
