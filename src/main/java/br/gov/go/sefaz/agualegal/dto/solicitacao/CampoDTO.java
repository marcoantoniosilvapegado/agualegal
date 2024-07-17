package br.gov.go.sefaz.agualegal.dto.solicitacao;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class CampoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Favor informar o nome do campo enviado!")
	private String nomeCampo;

	@NotBlank(message = "Favor informar o tipo do campo enviado!")	
	private String tipoCampo;

	@NotBlank(message = "Favor informar o conteudo do campo enviado")
	private String conteudoCampo;

	public CampoDTO() {
		super();		
	}

	public CampoDTO(String nomeCampo, String tipoCampo, String conteudoCampo) {
		super();
		this.nomeCampo = nomeCampo;
		this.tipoCampo = tipoCampo;
		this.conteudoCampo = conteudoCampo;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public String getConteudoCampo() {
		return conteudoCampo;
	}

	public void setConteudoCampo(String conteudoCampo) {
		this.conteudoCampo = conteudoCampo;
	}

}
