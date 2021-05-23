package br.com.logisticaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.logisticaapi.domain.model.Client;
import br.com.logisticaapi.domain.repository.ClientRepository;
import br.com.logisticaapi.domain.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	private ClientRepository repository;
	private ClientService service;
	
	
	
	public ClientController(ClientRepository repository, ClientService service) {
		this.repository = repository;
		this.service = service;
	}

	@GetMapping
	public List<Client> getClients(@PathVariable Long clientId) {
		return repository.findAll();
	}
	
	@GetMapping("/{clientId}")
	public Client findClient(@PathVariable Long clientId) {
		return repository.findById(clientId).get();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client created(@Valid @RequestBody Client client) {
		return service.create(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> update(@Valid @RequestBody Long clientId, @Valid @RequestBody Client client) {
		if (!repository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(clientId);
		client = service.create(client);
		
		return ResponseEntity.ok(client);
	}
	
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> remove(@Valid @RequestBody Long clientId) {
		if (!repository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		service.remove(clientId);
		
		return ResponseEntity.noContent().build();
	}
}
