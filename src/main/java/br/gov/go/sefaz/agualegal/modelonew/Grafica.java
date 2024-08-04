package br.gov.go.sefaz.agualegal.modelonew;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TAB_GRAFICA", uniqueConstraints = { @UniqueConstraint(columnNames = { "cnpj", "razao_social" }) })
public class Grafica {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grafica")
	@SequenceGenerator(name = "seq_grafica", sequenceName = "seq_tab_grafica", allocationSize = 1)
	@Column(name = "id_grafica")
	private Integer idGrafica;

	@Column(name = "cnpj", nullable = false, length = 14)
	private String cnpj;

	@Column(name = "razao_social", nullable = false, length = 200)
	private String razaoSocial;

	@Column(name = "nome_fantasia", nullable = false, length = 200)
	private String nomeFantasia;

	public Grafica() {
	
	}

	public Integer getIdGrafica() {
		return idGrafica;
	}

	public void setIdGrafica(Integer idGrafica) {
		this.idGrafica = idGrafica;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public String toString() {
		return "Grafica [idGrafica=" + idGrafica + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia="
				+ nomeFantasia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, idGrafica, nomeFantasia, razaoSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grafica other = (Grafica) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(idGrafica, other.idGrafica)
				&& Objects.equals(nomeFantasia, other.nomeFantasia) && Objects.equals(razaoSocial, other.razaoSocial);
	}

}
