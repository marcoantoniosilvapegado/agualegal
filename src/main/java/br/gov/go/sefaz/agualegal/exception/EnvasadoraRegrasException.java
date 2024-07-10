package br.gov.go.sefaz.agualegal.exception;

public class EnvasadoraRegrasException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnvasadoraRegrasException(String message) {
		super(message);
	}
	
	public EnvasadoraRegrasException(String message, Integer codigo) {
		super(message);
		this.codigo = codigo;
	}
	
	private Integer codigo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	
	
}
