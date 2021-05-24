package br.com.logisticaapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Destiny {

	
	@Column(name = "destiny_name")
	private String name;
	@Column(name = "destiny_street")
	private String street;
	@Column(name = "destiny_number")
	private String number;
	@Column(name = "destiny_complement")
	private String complement;
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
