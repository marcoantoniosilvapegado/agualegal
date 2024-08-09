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
@Table(name = "TAB_TIPO_RESPOSTA")
public class TipoResposta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_resposta")
	@SequenceGenerator(name = "seq_tipo_resposta", sequenceName = "seq_tab_tipo_resposta", allocationSize = 1)
	@Column(name = "id_tipo_resposta", nullable = false)
	private Long idTipoResposta;

	@Column(name = "tipo_resposta", unique = true, length = 20)
	private String tipoResposta;

	public TipoResposta() {
		
	}

	public TipoResposta(Long idTipoResposta, String tipoResposta) {
		this.idTipoResposta = idTipoResposta;
		this.tipoResposta = tipoResposta;
	}

	public Long getIdTipoResposta() {
		return idTipoResposta;
	}

	public void setIdTipoResposta(Long idTipoResposta) {
		this.idTipoResposta = idTipoResposta;
	}

	public String getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(String tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	@Override
	public String toString() {
		return "TipoResposta [idTipoResposta=" + idTipoResposta + ", tipoResposta=" + tipoResposta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoResposta, tipoResposta);
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
		return Objects.equals(idTipoResposta, other.idTipoResposta) && Objects.equals(tipoResposta, other.tipoResposta);
	}

}
