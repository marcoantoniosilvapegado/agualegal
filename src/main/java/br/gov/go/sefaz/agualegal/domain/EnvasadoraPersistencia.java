package br.gov.go.sefaz.agualegal.domain;

import java.util.Objects;

import br.gov.go.sefaz.agualegal.dto.solicitacao.CadastroDTO;
import br.gov.go.sefaz.agualegal.dto.solicitacao.EnderecoDTO;
import br.gov.go.sefaz.agualegal.modelo.Envasadora;
import br.gov.go.sefaz.agualegal.utils.UtilsAguaLegal;

public class EnvasadoraPersistencia {

	private String idEnvasadora;

	private String cnpj;

	private String razaoSocial;

	private String nomeFantasia;

	private String inscricaoEstadual;

	private String idTipoAgua;

	private String enderecoEnvasador;

	private String coordenadasEnvasador;

	private String enderecoEnvase;

	private String coordenadasEnvase;

	public EnvasadoraPersistencia() {
		
	}
	
	public EnvasadoraPersistencia(CadastroDTO cadastroDTO, EnderecoDTO enderecoDTO, String tipoAgua,
			String idEnvasadora) {
		if(enderecoDTO!= null) {
			this.enderecoEnvasador = UtilsAguaLegal.isEmpty(enderecoDTO.getEnderecoEnvasador())?""
					:enderecoDTO.getEnderecoEnvasador();
			this.coordenadasEnvasador = UtilsAguaLegal.isEmpty(enderecoDTO.getCoordenadasEnvasador())?""
					:enderecoDTO.getCoordenadasEnvasador();
			
			this.enderecoEnvase = UtilsAguaLegal.isEmpty(enderecoDTO.getEnderecoEnvase())?""
					:enderecoDTO.getEnderecoEnvase();
			this.coordenadasEnvase = UtilsAguaLegal.isEmpty(enderecoDTO.getCoordenadasEnvase())?""
					:enderecoDTO.getCoordenadasEnvase();			
		}
		
		if(cadastroDTO!=null) {
			this.cnpj = UtilsAguaLegal.isEmpty(cadastroDTO.getCnpj())?"":cadastroDTO.getCnpj();
			this.razaoSocial = UtilsAguaLegal.isEmpty(cadastroDTO.getRazaoSocial())?"":cadastroDTO.getRazaoSocial();
			this.nomeFantasia = UtilsAguaLegal.isEmpty(cadastroDTO.getNomeFantasia())?"":cadastroDTO.getNomeFantasia();
			this.inscricaoEstadual = UtilsAguaLegal.isEmpty(cadastroDTO.getInscricaoEstadual())?"":cadastroDTO.getInscricaoEstadual();		
		}
		this.idTipoAgua = tipoAgua;
		this.idEnvasadora = idEnvasadora;
	}

	public EnvasadoraPersistencia(String idEnvasadora, String cnpj, String razaoSocial, String nomeFantasia,
			String inscricaoEstadual, String idTipoAgua, String enderecoEnvasador, String coordenadasEnvasador,
			String enderecoEnvase, String coordenadasEnvase) {
		super();
		this.idEnvasadora = idEnvasadora;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.inscricaoEstadual = inscricaoEstadual;
		this.idTipoAgua = idTipoAgua;
		this.enderecoEnvasador = enderecoEnvasador;
		this.coordenadasEnvasador = coordenadasEnvasador;
		this.enderecoEnvase = enderecoEnvase;
		this.coordenadasEnvase = coordenadasEnvase;
	}

	public String getIdEnvasadora() {
		return idEnvasadora;
	}

	public void setIdEnvasadora(String idEnvasadora) {
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

	public String getIdTipoAgua() {
		return idTipoAgua;
	}

	public void setIdTipoAgua(String idTipoAgua) {
		this.idTipoAgua = idTipoAgua;
	}

	public String getEnderecoEnvasador() {
		return enderecoEnvasador;
	}

	public void setEnderecoEnvasador(String enderecoEnvasador) {
		this.enderecoEnvasador = enderecoEnvasador;
	}

	public String getCoordenadasEnvasador() {
		return coordenadasEnvasador;
	}

	public void setCoordenadasEnvasador(String coordenadasEnvasador) {
		this.coordenadasEnvasador = coordenadasEnvasador;
	}

	public String getEnderecoEnvase() {
		return enderecoEnvase;
	}

	public void setEnderecoEnvase(String enderecoEnvase) {
		this.enderecoEnvase = enderecoEnvase;
	}

	public String getCoordenadasEnvase() {
		return coordenadasEnvase;
	}

	public void setCoordenadasEnvase(String coordenadasEnvase) {
		this.coordenadasEnvase = coordenadasEnvase;
	}

	@Override
	public String toString() {
		return "EnvasadoraPersistencia [idEnvasadora=" + idEnvasadora + ", cnpj=" + cnpj + ", razaoSocial="
				+ razaoSocial + ", nomeFantasia=" + nomeFantasia + ", inscricaoEstadual=" + inscricaoEstadual
				+ ", idTipoAgua=" + idTipoAgua + ", enderecoEnvasador=" + enderecoEnvasador + ", coordenadasEnvasador="
				+ coordenadasEnvasador + ", enderecoEnvase=" + enderecoEnvase + ", coordenadasEnvase="
				+ coordenadasEnvase + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, coordenadasEnvasador, coordenadasEnvase, enderecoEnvasador, enderecoEnvase,
				idEnvasadora, idTipoAgua, inscricaoEstadual, nomeFantasia, razaoSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnvasadoraPersistencia other = (EnvasadoraPersistencia) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(coordenadasEnvasador, other.coordenadasEnvasador)
				&& Objects.equals(coordenadasEnvase, other.coordenadasEnvase)
				&& Objects.equals(enderecoEnvasador, other.enderecoEnvasador)
				&& Objects.equals(enderecoEnvase, other.enderecoEnvase)
				&& Objects.equals(idEnvasadora, other.idEnvasadora) && Objects.equals(idTipoAgua, other.idTipoAgua)
				&& Objects.equals(inscricaoEstadual, other.inscricaoEstadual)
				&& Objects.equals(nomeFantasia, other.nomeFantasia) && Objects.equals(razaoSocial, other.razaoSocial);
	}

}
