package br.com.logisticaapi.domain.service;

import org.springframework.stereotype.Service;

import br.com.logisticaapi.domain.exceptions.EntityNotFoundExceptions;
import br.com.logisticaapi.domain.model.Delivery;
import br.com.logisticaapi.domain.repository.DeliveryRepository;

@Service
public class FindDeliveryService {

	private DeliveryRepository deliveryRepository;
	
	
	
	public FindDeliveryService(DeliveryRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}



	public Delivery find(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new EntityNotFoundExceptions("Entrega não encontrada!!"));
	}
	
}
