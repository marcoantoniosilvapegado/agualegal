package br.gov.go.sefaz.agualegal.exception;

public class SolicitacaoCredenciamentoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SolicitacaoCredenciamentoException(String message) {
		super(message);
	}

	public SolicitacaoCredenciamentoException(String message, Integer codigo) {
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
