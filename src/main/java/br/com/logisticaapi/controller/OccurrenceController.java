package br.com.logisticaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.logisticaapi.api.mapper.OccurrenceMapper;
import br.com.logisticaapi.api.model.OccurrenceResponse;
import br.com.logisticaapi.api.model.request.OccurrenceRequest;
import br.com.logisticaapi.domain.model.Delivery;
import br.com.logisticaapi.domain.model.Occurrence;
import br.com.logisticaapi.domain.service.FindDeliveryService;
import br.com.logisticaapi.domain.service.RegisterOccurrenceService;

@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {

	
	private RegisterOccurrenceService service;
	private OccurrenceMapper occurrenceMapper;
	private FindDeliveryService findDeliveryService;
	
	
	
	public OccurrenceController(RegisterOccurrenceService service, OccurrenceMapper occurrenceMapper,FindDeliveryService findDeliveryService) {
		this.service = service;
		this.occurrenceMapper = occurrenceMapper;
		this.findDeliveryService = findDeliveryService;
	}



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceResponse register(@PathVariable Long deliveryId, @Valid @RequestBody OccurrenceRequest request) {
		Occurrence registerOccurrence =  service.register(deliveryId, request.getDescription());
		return occurrenceMapper.toModel(registerOccurrence);
	}
	
	@GetMapping
	public List<OccurrenceResponse> list(@PathVariable Long deliveryId){
		Delivery delivery = findDeliveryService.find(deliveryId);
		return occurrenceMapper.toCollectionResponse(delivery.getOccurrences());
	}
	
}
