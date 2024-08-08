package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_MOTIVO_INDEFERIMENTO")
public class MotivoIndeferimento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_motivo_indeferimento")
	@SequenceGenerator(name = "seq_motivo_indeferimento", sequenceName = "seq_tab_motivo_indeferimento", allocationSize = 1)
	@Column(name = "id_motivo_indeferimento")
	private Integer idMotivoIndeferimento;

	@Column(name = "motivo_indeferimento", nullable = false, length = 200)
	private String descricaoMotivo;

	@ManyToOne
	@JoinColumn(name = "id_tipo_analise")
	private TipoAnalise tipoAnalise;

	public MotivoIndeferimento() {

	}

	public Integer getIdMotivoIndeferimento() {
		return idMotivoIndeferimento;
	}

	public void setIdMotivoIndeferimento(Integer idMotivoIndeferimento) {
		this.idMotivoIndeferimento = idMotivoIndeferimento;
	}

	public TipoAnalise getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(TipoAnalise tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	public String getDescricaoMotivo() {
		return descricaoMotivo;
	}

	public void setDescricaoMotivo(String descricaoMotivo) {
		this.descricaoMotivo = descricaoMotivo;
	}

	@Override
	public String toString() {
		return "MotivoIndeferimento [idMotivoIndeferimento=" + idMotivoIndeferimento + ", descricaoMotivo="
				+ descricaoMotivo + ", tipoAnalise=" + tipoAnalise + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoMotivo, idMotivoIndeferimento, tipoAnalise);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MotivoIndeferimento other = (MotivoIndeferimento) obj;
		return Objects.equals(descricaoMotivo, other.descricaoMotivo)
				&& Objects.equals(idMotivoIndeferimento, other.idMotivoIndeferimento)
				&& Objects.equals(tipoAnalise, other.tipoAnalise);
	}

}
