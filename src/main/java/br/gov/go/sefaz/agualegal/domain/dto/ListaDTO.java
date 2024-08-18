package br.gov.go.sefaz.agualegal.domain.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ListaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CampoDTO> listaCampos;

	public ListaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ListaDTO(List<CampoDTO> listaCampos) {
		super();
		this.listaCampos = listaCampos;
	}

	public List<CampoDTO> getListaCampos() {
		return listaCampos;
	}

	public void setListaCampos(List<CampoDTO> listaCampos) {
		this.listaCampos = listaCampos;
	}

	@Override
	public String toString() {
		return "ListaDTO [listaCampos=" + listaCampos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaCampos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaDTO other = (ListaDTO) obj;
		return Objects.equals(listaCampos, other.listaCampos);
	}

}
