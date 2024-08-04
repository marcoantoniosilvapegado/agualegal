package br.gov.go.sefaz.agualegal.modelonew;

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
@Table(name = "TAB_RESPONSAVEL_ENVASADORA")
public class ResponsavelEnvasadora {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_responsavel_envasadora")
	@SequenceGenerator(name = "seq_responsavel_envasadora", sequenceName = "seq_tab_responsavel_envasadora", allocationSize = 1)
	@Column(name = "id_responsavel_envasadora")
	private Integer idResponsavelEnvasadora;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "telefone", nullable = false)
	private String telefone;

	@Column(name = "status", length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
	private Character status;

	public ResponsavelEnvasadora() {
		
	}

	@ManyToOne
	@JoinColumn(name = "id_envasadora", nullable = false)
	private Envasadora envasadora;

	// Getters and Setters
	public Integer getIdResponsavelEnvasadora() {
		return idResponsavelEnvasadora;
	}

	public void setIdResponsavelEnvasadora(Integer idResponsavelEnvasadora) {
		this.idResponsavelEnvasadora = idResponsavelEnvasadora;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Envasadora getEnvasadora() {
		return envasadora;
	}

	public void setEnvasadora(Envasadora envasadora) {
		this.envasadora = envasadora;
	}

	@Override
	public String toString() {
		return "ResponsavelEnvasadora [idResponsavelEnvasadora=" + idResponsavelEnvasadora + ", cpf=" + cpf + ", rg="
				+ rg + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", status=" + status
				+ ", envasadora=" + envasadora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, envasadora, idResponsavelEnvasadora, nome, rg, status, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsavelEnvasadora other = (ResponsavelEnvasadora) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(envasadora, other.envasadora)
				&& Objects.equals(idResponsavelEnvasadora, other.idResponsavelEnvasadora)
				&& Objects.equals(nome, other.nome) && Objects.equals(rg, other.rg)
				&& Objects.equals(status, other.status) && Objects.equals(telefone, other.telefone);
	}

}