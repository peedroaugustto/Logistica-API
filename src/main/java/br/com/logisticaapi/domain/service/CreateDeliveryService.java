package br.com.logisticaapi.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logisticaapi.domain.model.Client;
import br.com.logisticaapi.domain.model.Delivery;
import br.com.logisticaapi.domain.model.DeliveryStatus;
import br.com.logisticaapi.domain.repository.DeliveryRepository;

@Service
public class CreateDeliveryService {

	
	private DeliveryRepository deliveryRepository;
	private ClientService clientService;
	

	public CreateDeliveryService(DeliveryRepository deliveryRepository, ClientService clientService) {
		this.deliveryRepository = deliveryRepository;
		this.clientService = clientService;
	}
	
	@Transactional
	public Delivery create(Delivery delivery) {
		Client client = clientService.find(delivery.getClient().getId());
		delivery.setClient(client);
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setOrderDate(OffsetDateTime.now());
		
		return deliveryRepository.save(delivery);
	}
	
	
	
	
}
