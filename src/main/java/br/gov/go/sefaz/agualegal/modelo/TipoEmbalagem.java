package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_TIPO_EMBALAGEM")
public class TipoEmbalagem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_embalagem")
	@SequenceGenerator(name = "seq_tipo_embalagem", sequenceName = "APL_AGUALEGAL.seq_tab_tipo_embalagem", allocationSize = 1)
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
