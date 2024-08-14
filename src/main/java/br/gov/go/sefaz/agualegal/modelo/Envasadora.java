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
import jakarta.persistence.UniqueConstraint;

import br.gov.go.sefaz.agualegal.dto.solicitacao.CadastroDTO;

@Entity
@Table(schema = "APL_AGUALEGAL", name = "TAB_ENVASADORA", uniqueConstraints = { @UniqueConstraint(columnNames = { "cnpj", "razao_social" }) })
public class Envasadora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_envasadora")
	@SequenceGenerator(name = "seq_envasadora", sequenceName = "APL_AGUALEGAL.seq_tab_envasadora", allocationSize = 1)
	@Column(name = "id_envasadora")
	private Integer idEnvasadora;

	@Column(name = "cnpj", nullable = false, length = 14)
	private String cnpj;

	@Column(name = "razao_social", nullable = false, length = 200)
	private String razaoSocial;

	@Column(name = "nome_fantasia", nullable = false, length = 200)
	private String nomeFantasia;

	@Column(name = "inscricao_estadual", nullable = false, length = 20)
	private String inscricaoEstadual;

	@Column(name = "endereco", nullable = true, length = 200)
	private String endereco;

	@Column(name = "coordenada", nullable = true, length = 24)
	private String coordenada;

	@Column(name = "endereco_envase", nullable = true, length = 200)
	private String enderecoEnvase;

	@Column(name = "coordenada_envase", nullable = true, length = 24)
	private String coordenadaEnvase;
	
	public Envasadora() {
		
	}

	public Envasadora(CadastroDTO cadastro, TipoAgua tipoAgua) {
		this.cnpj = cadastro.getCnpj();
		this.razaoSocial = cadastro.getRazaoSocial();
		this.nomeFantasia = cadastro.getNomeFantasia();
		this.inscricaoEstadual = cadastro.getInscricaoEstadual();
		this.tipoAgua = tipoAgua;
		this.endereco = "";
		this.coordenada = "";
		this.enderecoEnvase = "";
		this.coordenadaEnvase = "";
	}

	public Envasadora(String cnpj, String razaoSocial, String nomeFantasia, String inscricaoEstadual, String endereco,
			String coordenada, String enderecoEnvase, String coordenadaEnvase, TipoAgua tipoAgua) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.inscricaoEstadual = inscricaoEstadual;
		this.endereco = endereco;
		this.coordenada = coordenada;
		this.enderecoEnvase = enderecoEnvase;
		this.coordenadaEnvase = coordenadaEnvase;
		this.tipoAgua = tipoAgua;
	}

	@ManyToOne
	@JoinColumn(name = "id_tipo_agua", nullable = false)
	private TipoAgua tipoAgua;

	// Getters and Setters
	public Integer getIdEnvasadora() {
		return idEnvasadora;
	}

	public void setIdEnvasadora(Integer idEnvasadora) {
		this.idEnvasadora = idEnvasadora;
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

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}

	public String getEnderecoEnvase() {
		return enderecoEnvase;
	}

	public void setEnderecoEnvase(String enderecoEnvase) {
		this.enderecoEnvase = enderecoEnvase;
	}

	public String getCoordenadaEnvase() {
		return coordenadaEnvase;
	}

	public void setCoordenadaEnvase(String coordenadaEnvase) {
		this.coordenadaEnvase = coordenadaEnvase;
	}

	public TipoAgua getTipoAgua() {
		return tipoAgua;
	}

	public void setTipoAgua(TipoAgua tipoAgua) {
		this.tipoAgua = tipoAgua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, coordenada, coordenadaEnvase, endereco, enderecoEnvase, idEnvasadora,
				inscricaoEstadual, nomeFantasia, razaoSocial, tipoAgua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Envasadora other = (Envasadora) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(coordenada, other.coordenada)
				&& Objects.equals(coordenadaEnvase, other.coordenadaEnvase) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(enderecoEnvase, other.enderecoEnvase)
				&& Objects.equals(idEnvasadora, other.idEnvasadora)
				&& Objects.equals(inscricaoEstadual, other.inscricaoEstadual)
				&& Objects.equals(nomeFantasia, other.nomeFantasia) && Objects.equals(razaoSocial, other.razaoSocial)
				&& Objects.equals(tipoAgua, other.tipoAgua);
	}

	@Override
	public String toString() {
		return "Envasadora [idEnvasadora=" + idEnvasadora + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial
				+ ", nomeFantasia=" + nomeFantasia + ", inscricaoEstadual=" + inscricaoEstadual + ", endereco="
				+ endereco + ", coordenada=" + coordenada + ", enderecoEnvase=" + enderecoEnvase + ", coordenadaEnvase="
				+ coordenadaEnvase + ", tipoAgua=" + tipoAgua + "]";
	}

}