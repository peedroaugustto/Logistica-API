package br.com.logisticaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.logisticaapi.api.mapper.DeliveryMapper;
import br.com.logisticaapi.api.model.DeliveryResponse;
import br.com.logisticaapi.api.model.request.DeliveryRequest;
import br.com.logisticaapi.domain.model.Delivery;
import br.com.logisticaapi.domain.repository.DeliveryRepository;
import br.com.logisticaapi.domain.service.CreateDeliveryService;
import br.com.logisticaapi.domain.service.FinishedDeliveryService;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	
	private CreateDeliveryService createDeliveryService;
	private DeliveryRepository deliveryRepository;
	private DeliveryMapper deliverylMapper;
	private FinishedDeliveryService finishedDeliveryService;
	
	public DeliveryController(CreateDeliveryService createDeliveryService, DeliveryRepository deliveryRepository, DeliveryMapper deliverylMapper,
			FinishedDeliveryService finishedDeliveryService ) {
		this.createDeliveryService = createDeliveryService;
		this.deliveryRepository = deliveryRepository;
		this.deliverylMapper = deliverylMapper;
		this.finishedDeliveryService = finishedDeliveryService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryResponse create(@Valid @RequestBody DeliveryRequest request) {
		Delivery entity = deliverylMapper.toEntity(request);
		Delivery entityNew = createDeliveryService.create(entity);
		return deliverylMapper.toModel(entityNew);
	}
	
	@GetMapping
	public List<DeliveryResponse> list(){
		return deliverylMapper.toCollectionResponse(deliveryRepository.findAll());
	}
	
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryResponse>find(@PathVariable Long deliveryId){
		return deliveryRepository.findById(deliveryId)
				.map(delivery ->ResponseEntity.ok(deliverylMapper.toModel(delivery)))
				
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{deliveryId}/finished")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finished(@PathVariable Long deliveryId) {
		finishedDeliveryService.finish(deliveryId);
	}
	
}
