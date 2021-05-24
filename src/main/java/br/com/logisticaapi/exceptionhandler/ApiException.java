package br.com.logisticaapi.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.logisticaapi.domain.exceptions.BussinesException;
import br.com.logisticaapi.domain.exceptions.EntityNotFoundExceptions;

@ControllerAdvice
public class ApiException extends ResponseEntityExceptionHandler{

	@Autowired
	MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorBody.Campo> campos = new ArrayList<>();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			campos.add(new ErrorBody.Campo(name,message));
		}
		
		
		ErrorBody error = new ErrorBody();
		error.setStatus(status.value());
		error.setDateHour(OffsetDateTime.now());
		error.setTitle("Campos Invalidos");
		error.setCampos(campos);
		
		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	@ExceptionHandler(BussinesException.class)
	public ResponseEntity<Object> handleBussinesException(BussinesException ex, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;

		ErrorBody error = new ErrorBody();
		error.setStatus(status.value());
		error.setDateHour(OffsetDateTime.now());
		error.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex,error,new HttpHeaders(),status,request);
	}
	
	
	@ExceptionHandler(EntityNotFoundExceptions.class)
	public ResponseEntity<Object> handleBussinesException(EntityNotFoundExceptions ex, WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;

		ErrorBody error = new ErrorBody();
		error.setStatus(status.value());
		error.setDateHour(OffsetDateTime.now());
		error.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex,error,new HttpHeaders(),status,request);
	}
}
