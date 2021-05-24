package br.com.logisticaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.logisticaapi.domain.model.Delivery;
import br.com.logisticaapi.domain.service.CreateDeliveryService;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	private CreateDeliveryService createDeliveryService;

	public DeliveryController(CreateDeliveryService createDeliveryService) {
		this.createDeliveryService = createDeliveryService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery create(@RequestBody Delivery delivery) {
		return createDeliveryService.create(delivery);
	}
	
}
