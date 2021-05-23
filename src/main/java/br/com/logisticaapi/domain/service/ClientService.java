package br.com.logisticaapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logisticaapi.domain.exceptions.BussinesException;
import br.com.logisticaapi.domain.model.Client;
import br.com.logisticaapi.domain.repository.ClientRepository;

@Service
public class ClientService {
	
	private ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	
	@Transactional
	public Client create(Client client) {
		boolean emailInUse = clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(clientExist -> !clientExist.equals(client));
		
		if(emailInUse) {
			throw new BussinesException("Já Existe Cliente com este Email!!");
		}
		
		
		return clientRepository.save(client);
	}
	
	
	@Transactional
	public void remove(Long clientId) {
		 clientRepository.deleteById(clientId);
	}
	

}
