package br.gov.go.sefaz.agualegal.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_RESPONSAVEL_ENVASADORA")
public class ResponsavelEnvasadora {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_responsavel_envasadora")
	@SequenceGenerator(name = "seq_responsavel_envasadora", sequenceName = "APL_AGUALEGAL.seq_tab_responsavel_envasadora", allocationSize = 1)
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