package br.com.logisticaapi.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.logisticaapi.domain.exceptions.BussinesException;

@Entity
@Table(name = "tb_delivery")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Client client;
	
	@Embedded
	private Destiny destiny;
	
	
	private BigDecimal rate;
	
	@OneToMany(mappedBy = "delivery" , cascade = CascadeType.ALL)
	private List<Occurrence> occurrences = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	private OffsetDateTime orderDate;
	private OffsetDateTime endDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Destiny getDestiny() {
		return destiny;
	}
	public void setDestiny(Destiny destiny) {
		this.destiny = destiny;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public DeliveryStatus getStatus() {
		return status;
	}
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
	public OffsetDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(OffsetDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public OffsetDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}
	
	public List<Occurrence> getOccurrences() {
		return occurrences;
	}
	public void setOccurrences(List<Occurrence> occurrences) {
		this.occurrences = occurrences;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Occurrence addOccurrence(String description) {
		Occurrence occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setRegisterDate(OffsetDateTime.now());
		occurrence.setDelivery(this);
		this.getOccurrences().add(occurrence);
		return occurrence;
	}
	public void finish() {
		if(!toBeFinished()) {
			throw new BussinesException("Entrega não pode ser finalizada!!");
		}
		
		setStatus(DeliveryStatus.FINISHED);
		setEndDate(OffsetDateTime.now());
	}
	
	public boolean toBeFinished() {
		return DeliveryStatus.PENDING.equals(getStatus());
	}
	
	
}
