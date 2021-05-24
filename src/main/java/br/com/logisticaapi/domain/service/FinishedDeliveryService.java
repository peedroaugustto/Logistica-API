package br.com.logisticaapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logisticaapi.domain.model.Delivery;
import br.com.logisticaapi.domain.repository.DeliveryRepository;

@Service
public class FinishedDeliveryService {
	
	private FindDeliveryService findDeliveryService;
	private DeliveryRepository deliveryRepository;
	
	
	public FinishedDeliveryService(FindDeliveryService findDeliveryService, DeliveryRepository deliveryRepository) {
		this.findDeliveryService = findDeliveryService;
		this.deliveryRepository = deliveryRepository;
	}
	
	@Transactional
	public void finish(Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		
		delivery.finish();
		deliveryRepository.save(delivery);
	}
	
	

}
