package br.com.logisticaapi.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.logisticaapi.domain.model.DeliveryStatus;

public class DeliveryResponse {

	private Long id;

	private ClientResumeModel client;
	
	private DestinyModel destiny;

	private BigDecimal rate;

	private DeliveryStatus status;

	private OffsetDateTime orderDate;
	private OffsetDateTime endDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DestinyModel getDestiny() {
		return destiny;
	}
	public void setDestiny(DestinyModel destiny) {
		this.destiny = destiny;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public DeliveryStatus getStatus() {
		return status;
	}
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
	public OffsetDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(OffsetDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public OffsetDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}
	public ClientResumeModel getClient() {
		return client;
	}
	public void setClient(ClientResumeModel client) {
		this.client = client;
	}
	
	
	

}
