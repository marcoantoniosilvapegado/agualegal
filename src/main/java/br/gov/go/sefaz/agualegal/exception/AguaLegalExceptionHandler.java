package br.gov.go.sefaz.agualegal.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.gov.go.sefaz.agualegal.domain.RespostaPadrao;

@ControllerAdvice
public class AguaLegalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request ){
		
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());
		
		for(FieldError x: e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);		
	}	
	
	@ExceptionHandler(TokenGraficaInvalidoException.class)
	public ResponseEntity<RespostaPadrao> validaTokenGrafica(TokenGraficaInvalidoException e, HttpServletRequest request){
		RespostaPadrao erro = new RespostaPadrao(e.getMessage(), e.getCodigo(), false);		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
}
