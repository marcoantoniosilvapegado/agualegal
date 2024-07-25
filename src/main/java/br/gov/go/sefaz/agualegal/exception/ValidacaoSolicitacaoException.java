package br.gov.go.sefaz.agualegal.exception;

public class ValidacaoSolicitacaoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ValidationError validationErrors;

    public ValidacaoSolicitacaoException(ValidationError validationErrors) {
        super(validationErrors.toString());
        this.validationErrors = validationErrors;
    }

    public ValidationError getValidationErrors() {
        return validationErrors;
    }

}
