package br.com.logisticaapi.api.model.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DeliveryRequest {

	@Valid
	@NotNull
	private ClientIdRequest client;
	
	@Valid
	@NotNull
	private DestinyRequest destiny;
	
	@NotNull
	private BigDecimal rate;

	public ClientIdRequest getClient() {
		return client;
	}

	public void setClient(ClientIdRequest client) {
		this.client = client;
	}

	public DestinyRequest getDestiny() {
		return destiny;
	}

	public void setDestiny(DestinyRequest destiny) {
		this.destiny = destiny;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	
	
	
	
}
