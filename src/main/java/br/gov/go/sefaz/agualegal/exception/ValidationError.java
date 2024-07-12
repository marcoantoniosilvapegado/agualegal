package br.gov.go.sefaz.agualegal.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ListableBeanFactory;

public class ValidationError extends StandardError{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}
	
	private List<FieldMessage> erros = new ArrayList<FieldMessage>();

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void setList(List<FieldMessage> erros) {
		this.erros = erros;
	}
	
	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}
	
	
}
