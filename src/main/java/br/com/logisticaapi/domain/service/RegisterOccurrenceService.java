package br.com.logisticaapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logisticaapi.domain.model.Delivery;
import br.com.logisticaapi.domain.model.Occurrence;

@Service
public class RegisterOccurrenceService {

	private FindDeliveryService findDeliveryService;
	
	
	
	public RegisterOccurrenceService(FindDeliveryService findDeliveryService) {
		this.findDeliveryService = findDeliveryService;
	}



	@Transactional
	public Occurrence register(Long deliveryId, String description) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		
		return delivery.addOccurrence(description);

	}
	
}
