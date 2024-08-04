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
@Table(name = "TAB_TIPO_EMBALAGEM")
public class TipoEmbalagem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_embalagem")
	@SequenceGenerator(name = "seq_tipo_embalagem", sequenceName = "seq_tab_tipo_embalagem", allocationSize = 1)
	@Column(name = "id_tipo_embalagem")
	private Integer idTipoEmbalagem;

	@Column(name = "tipo_embalagem", nullable = false, length = 50, unique = true)
	private String tipoEmbalagem;

	public TipoEmbalagem() {
	
	}

	public Integer getIdTipoEmbalagem() {
		return idTipoEmbalagem;
	}

	public void setIdTipoEmbalagem(Integer idTipoEmbalagem) {
		this.idTipoEmbalagem = idTipoEmbalagem;
	}

	public String getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(String tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	@Override
	public String toString() {
		return "TipoEmbalagem [idTipoEmbalagem=" + idTipoEmbalagem + ", tipoEmbalagem=" + tipoEmbalagem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoEmbalagem, tipoEmbalagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoEmbalagem other = (TipoEmbalagem) obj;
		return Objects.equals(idTipoEmbalagem, other.idTipoEmbalagem)
				&& Objects.equals(tipoEmbalagem, other.tipoEmbalagem);
	}

}
