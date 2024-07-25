package br.gov.go.sefaz.agualegal.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ordem;
	private String fieldName;
	private String message;

	public FieldMessage(String fieldName, String message, Integer ordem) {

		this.fieldName = fieldName;
		this.message = message;
		this.ordem = ordem;
	}

	public FieldMessage() {

	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Override
	public String toString() {
		return "FieldMessage [ordem=" + ordem + ", fieldName=" + fieldName + ", message=" + message + "]";
	}

}
