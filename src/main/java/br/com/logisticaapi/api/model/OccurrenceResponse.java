package br.com.logisticaapi.api.model;

import java.time.OffsetDateTime;

public class OccurrenceResponse {
	
	private Long id;
	private String description;
	private OffsetDateTime registerDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OffsetDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(OffsetDateTime registerDate) {
		this.registerDate = registerDate;
	}
	
	
	
}
