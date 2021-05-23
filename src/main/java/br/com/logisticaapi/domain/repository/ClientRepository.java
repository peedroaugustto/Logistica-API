package br.com.logisticaapi.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logisticaapi.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findByName(String name);
	List<Client> findByNameContaining(String name);
	
	Optional<Client> findByEmail(String email);
	
	

}
