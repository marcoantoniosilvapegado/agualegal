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
@Table(name = "TAB_CADASTRO_CNAE")
public class CadastroCnae {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CADASTRO_CNAE")
	@SequenceGenerator(name = "SEQ_CADASTRO_CNAE", sequenceName = "SEQ_TAB_CADASTRO_CNAE", allocationSize = 1)
	@Column(name = "ID_TAB_CADASTRO_CNAE", nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_CADASTRO", referencedColumnName = "ID_CADASTRO")
	private Cadastro cadastro;

	@Column(name = "CNAE", precision = 7)
	private Long cnae;

	@Column(name = "STATUS")
	private Integer status;

	public CadastroCnae(Integer id, Cadastro cadastro, Long cnae, Integer status) {
		super();
		this.id = id;
		this.cadastro = cadastro;
		this.cnae = cnae;
		this.status = status;
	}

	public CadastroCnae() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public Long getCnae() {
		return cnae;
	}

	public void setCnae(Long cnae) {
		this.cnae = cnae;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CadastroCnae [id=" + id + ", cadastro=" + cadastro + ", cnae=" + cnae + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cadastro, cnae, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroCnae other = (CadastroCnae) obj;
		return Objects.equals(cadastro, other.cadastro) && Objects.equals(cnae, other.cnae)
				&& Objects.equals(id, other.id) && Objects.equals(status, other.status);
	}

}
