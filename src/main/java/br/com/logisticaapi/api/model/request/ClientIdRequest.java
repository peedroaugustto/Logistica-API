package br.com.logisticaapi.api.model.request;

import javax.validation.constraints.NotNull;

public class ClientIdRequest {
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
