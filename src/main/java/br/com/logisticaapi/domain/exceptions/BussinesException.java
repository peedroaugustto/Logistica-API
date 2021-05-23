package br.com.logisticaapi.domain.exceptions;

public class BussinesException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BussinesException(String message) {
		super(message);
	}

}
