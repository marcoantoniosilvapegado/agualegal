package br.gov.go.sefaz.agualegal.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaCamposResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private List<CampoResponseDTO> listaCampos = new ArrayList<CampoResponseDTO>();

	public ListaCamposResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListaCamposResponseDTO(List<CampoResponseDTO> listaCampos) {
		super();
		this.listaCampos = listaCampos;
	}

	public List<CampoResponseDTO> getListaCampos() {
		return listaCampos;
	}

	public void setListaCampos(List<CampoResponseDTO> listaCampos) {
		this.listaCampos = listaCampos;
	}

}
