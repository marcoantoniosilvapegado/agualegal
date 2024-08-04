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
	private String motivoIndeferimento;

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

	public String getMotivoIndeferimento() {
		return motivoIndeferimento;
	}

	public void setMotivoIndeferimento(String motivoIndeferimento) {
		this.motivoIndeferimento = motivoIndeferimento;
	}

	public TipoAnalise getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(TipoAnalise tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	@Override
	public String toString() {
		return "MotivoIndeferimento [idMotivoIndeferimento=" + idMotivoIndeferimento + ", motivoIndeferimento="
				+ motivoIndeferimento + ", tipoAnalise=" + tipoAnalise + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMotivoIndeferimento, motivoIndeferimento, tipoAnalise);
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
		return Objects.equals(idMotivoIndeferimento, other.idMotivoIndeferimento)
				&& Objects.equals(motivoIndeferimento, other.motivoIndeferimento)
				&& Objects.equals(tipoAnalise, other.tipoAnalise);
	}

}
