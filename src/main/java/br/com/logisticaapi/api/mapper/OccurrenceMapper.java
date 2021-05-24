package br.com.logisticaapi.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.logisticaapi.api.model.OccurrenceResponse;
import br.com.logisticaapi.domain.model.Occurrence;

@Component
public class OccurrenceMapper {
	
	private ModelMapper modelMapper;

	public OccurrenceMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public OccurrenceResponse toModel(Occurrence occurrence) {
		return modelMapper.map(occurrence, OccurrenceResponse.class);
	}
	
	
	public List<OccurrenceResponse> toCollectionResponse(List<Occurrence> occurrences){
		return occurrences.stream().map(this::toModel).collect(Collectors.toList());
	}

}
