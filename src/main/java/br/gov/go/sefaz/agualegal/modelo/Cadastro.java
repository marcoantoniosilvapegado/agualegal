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
@Table(schema = "APL_AGUALEGAL", name = "TAB_CADASTRO")
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CADASTRO")
	@SequenceGenerator(name = "SEQ_CADASTRO", sequenceName = "APL_AGUALEGAL.SEQ_TAB_CADASTRO", allocationSize = 1)
	@Column(name = "ID_CADASTRO", nullable = false)
	private Integer id;

	@Column(name = "RAZAO_SOCIAL", length = 100)
	private String razaoSocial;

	@Column(name = "CNPJ", length = 14)
	private String cnpj;

	@Column(name = "IE", precision = 12)
	private Long ie;

	@Column(name = "SITUACAO_FISCAL")
	private Integer situacaoFiscal;

	public Cadastro() {
		
	}

	public Cadastro(Integer id, String razaoSocial, String cnpj, Long ie, Integer situacaoFiscal) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.ie = ie;
		this.situacaoFiscal = situacaoFiscal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getIe() {
		return ie;
	}

	public void setIe(Long ie) {
		this.ie = ie;
	}

	public Integer getSituacaoFiscal() {
		return situacaoFiscal;
	}

	public void setSituacaoFiscal(Integer situacaoFiscal) {
		this.situacaoFiscal = situacaoFiscal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, id, ie, razaoSocial, situacaoFiscal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id) && Objects.equals(ie, other.ie)
				&& Objects.equals(razaoSocial, other.razaoSocial)
				&& Objects.equals(situacaoFiscal, other.situacaoFiscal);
	}

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", ie=" + ie
				+ ", situacaoFiscal=" + situacaoFiscal + "]";
	}

}
