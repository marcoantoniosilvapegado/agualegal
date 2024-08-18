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
@Table(schema = "APL_AGUALEGAL", name = "TAB_SITUACAOCAD_SEFAZ")
public class SituacaoCadSefaz {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sitcad_sefaz")
	@SequenceGenerator(name = "seq_sitcad_sefaz", sequenceName = "APL_AGUALEGAL.seq_tab_sitcad_sefaz", allocationSize = 1)
	@Column(name = "id_situacaocad_sefaz", nullable = false)
	private Long id;

	@Column(name = "descricao_situacao", unique = true, length = 30)
	private String descricaoSituacao;

	public SituacaoCadSefaz() {
		// TODO Auto-generated constructor stub
	}

	public SituacaoCadSefaz(Long id, String descricaoSituacao) {
		super();
		this.id = id;
		this.descricaoSituacao = descricaoSituacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoSituacao() {
		return descricaoSituacao;
	}

	public void setDescricaoSituacao(String descricaoSituacao) {
		this.descricaoSituacao = descricaoSituacao;
	}

	@Override
	public String toString() {
		return "SituacaoCadSefaz [id=" + id + ", descricaoSituacao=" + descricaoSituacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoSituacao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SituacaoCadSefaz other = (SituacaoCadSefaz) obj;
		return Objects.equals(descricaoSituacao, other.descricaoSituacao) && Objects.equals(id, other.id);
	}

}
