package br.com.logisticaapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logisticaapi.domain.model.Delivery;

public interface DeliveryRepository  extends JpaRepository<Delivery, Long>{

}
