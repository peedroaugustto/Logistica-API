package br.com.logisticaapi.domain.exceptions;

public class EntityNotFoundExceptions extends BussinesException {

	private static final long serialVersionUID = 1L;
	
	
	public EntityNotFoundExceptions(String message) {
		super(message);
	}


}
