package br.com.logisticaapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Destiny {

	
	@NotNull
	@Column(name = "destiny_name")
	private String name;
	
	@NotNull
	@Column(name = "destiny_street")
	private String street;
	
	@NotNull
	@Column(name = "destiny_number")
	private String number;
	
	@NotNull
	@Column(name = "destiny_complement")
	private String complement;
	
	@NotNull
	@Column(name = "destiny_neighborhood")
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
