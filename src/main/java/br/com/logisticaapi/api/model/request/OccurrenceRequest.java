package br.com.logisticaapi.api.model.request;

import javax.validation.constraints.NotBlank;

public class OccurrenceRequest {

	@NotBlank
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
