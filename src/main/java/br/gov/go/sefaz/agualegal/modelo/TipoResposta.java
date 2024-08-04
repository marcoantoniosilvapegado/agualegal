package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "TAB_TIPO_RESPOSTA")
public class TipoResposta {

	@Id
	@Column(name = "id_tipo_resposta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_resposta", nullable = false, length = 200, unique = true)
	private String tipoResposta;

	public TipoResposta() {
		
	}

	public TipoResposta(Long id, String tipoResposta) {
		super();
		this.id = id;
		this.tipoResposta = tipoResposta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(String tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	@Override
	public String toString() {
		return "TipoResposta [id=" + id + ", tipoResposta=" + tipoResposta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoResposta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoResposta other = (TipoResposta) obj;
		return Objects.equals(id, other.id) && Objects.equals(tipoResposta, other.tipoResposta);
	}

	

}
