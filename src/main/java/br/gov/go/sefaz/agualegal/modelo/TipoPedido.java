package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_TIPO_PEDIDO")
public class TipoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_pedido")
	@SequenceGenerator(name = "seq_tipo_pedido", sequenceName = "seq_tab_tipo_pedido", allocationSize = 1)
	@Column(name = "id_tipo_pedido")
	private Integer idTipoPedido;

	@Column(name = "tipo_pedido", nullable = false, length = 50, unique = true)
	private String tipoPedido;

	public TipoPedido() {
	
	}

	public Integer getIdTipoPedido() {
		return idTipoPedido;
	}

	public void setIdTipoPedido(Integer idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	@Override
	public String toString() {
		return "TipoPedido [idTipoPedido=" + idTipoPedido + ", tipoPedido=" + tipoPedido + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoPedido, tipoPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPedido other = (TipoPedido) obj;
		return Objects.equals(idTipoPedido, other.idTipoPedido) && Objects.equals(tipoPedido, other.tipoPedido);
	}

}