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
@Table(schema = "APL_AGUALEGAL", name = "TAB_STATUS")
public class TipoStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status")
	@SequenceGenerator(name = "seq_status", sequenceName = "APL_AGUALEGAL.seq_tab_status", allocationSize = 1)
	@Column(name = "id_status")
	private Integer id;

	@Column(name = "descricao_status", nullable = false, length = 30, unique = true)
	private String descricaoStatus;

	public TipoStatus() {
		
	}

	public TipoStatus(Integer id, String descricaoStatus) {		
		this.id = id;
		this.descricaoStatus = descricaoStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	@Override
	public String toString() {
		return "TipoStatus [id=" + id + ", descricaoStatus=" + descricaoStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoStatus, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoStatus other = (TipoStatus) obj;
		return Objects.equals(descricaoStatus, other.descricaoStatus) && Objects.equals(id, other.id);
	}

}
