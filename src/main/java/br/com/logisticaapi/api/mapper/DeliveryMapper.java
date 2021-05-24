package br.com.logisticaapi.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.logisticaapi.api.model.DeliveryResponse;
import br.com.logisticaapi.api.model.request.DeliveryRequest;
import br.com.logisticaapi.domain.model.Delivery;

@Component
public class DeliveryMapper {
	
	private ModelMapper modelMapper;

	public DeliveryMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	
	public DeliveryResponse toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryResponse.class);
	}
	
	public List<DeliveryResponse> toCollectionResponse(List<Delivery> deliveries){
		return deliveries.stream().map(this::toModel).collect(Collectors.toList());
	}

	
	public Delivery toEntity(DeliveryRequest request) {
		return modelMapper.map(request, Delivery.class);
	}
	
	
}
