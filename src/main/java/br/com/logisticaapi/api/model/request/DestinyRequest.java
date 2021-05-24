package br.com.logisticaapi.api.model.request;

import javax.validation.constraints.NotNull;

public class DestinyRequest {

	@NotNull
	private String name;
	
	@NotNull
	private String street;
	
	@NotNull
	private String number;
	
	@NotNull
	private String complement;
	
	@NotNull
	private String neighborhood;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	
	
}
