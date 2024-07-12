package br.gov.go.sefaz.agualegal.dto;

import java.io.Serializable;
import java.util.Objects;

public class CampoResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeCampo;
	private String descricaoCampo;
	private String tipoAnalise;
	private String tipoFormato;
	private Boolean dadoObrigatorio;

	public CampoResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CampoResponseDTO(String nomeCampo, String descricaoCampo, String tipoAnalise, String tipoFormato,
			Boolean dadoObrigatorio) {
		super();
		this.nomeCampo = nomeCampo;
		this.descricaoCampo = descricaoCampo;
		this.tipoAnalise = tipoAnalise;
		this.tipoFormato = tipoFormato;
		this.dadoObrigatorio = dadoObrigatorio;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getDescricaoCampo() {
		return descricaoCampo;
	}

	public void setDescricaoCampo(String descricaoCampo) {
		this.descricaoCampo = descricaoCampo;
	}

	public String getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(String tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
	}

	public String getTipoFormato() {
		return tipoFormato;
	}

	public void setTipoFormato(String tipoFormato) {
		this.tipoFormato = tipoFormato;
	}

	public Boolean getDadoObrigatorio() {
		return dadoObrigatorio;
	}

	public void setDadoObrigatorio(Boolean dadoObrigatorio) {
		this.dadoObrigatorio = dadoObrigatorio;
	}

	@Override
	public String toString() {
		return "CampoResponseDTO [nomeCampo=" + nomeCampo + ", descricaoCampo=" + descricaoCampo + ", tipoAnalise="
				+ tipoAnalise + ", tipoFormato=" + tipoFormato + ", dadoObrigatorio=" + dadoObrigatorio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dadoObrigatorio, descricaoCampo, nomeCampo, tipoAnalise, tipoFormato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampoResponseDTO other = (CampoResponseDTO) obj;
		return Objects.equals(dadoObrigatorio, other.dadoObrigatorio)
				&& Objects.equals(descricaoCampo, other.descricaoCampo) && Objects.equals(nomeCampo, other.nomeCampo)
				&& Objects.equals(tipoAnalise, other.tipoAnalise) && Objects.equals(tipoFormato, other.tipoFormato);
	}

}
