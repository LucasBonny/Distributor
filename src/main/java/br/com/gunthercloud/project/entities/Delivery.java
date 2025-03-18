package br.com.gunthercloud.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.project.entities.dto.DeliveryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_delivery")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dateTimeDelivery;
	
	@ManyToOne
	private Supplier supplier;
	
	@ManyToMany
	private List<Product> products;
	
	
	public Delivery() {
		
	}
	
	public Delivery(Long id, Instant dateTimeDelivery, Supplier supplier) {
		this.id = id;
		this.dateTimeDelivery = dateTimeDelivery;
		this.supplier = supplier;
	}

	public Delivery (DeliveryDTO object) {
		BeanUtils.copyProperties(object, this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDateTimeDelivery() {
		return dateTimeDelivery;
	}

	public void setDateTimeDelivery(Instant dateTimeDelivery) {
		this.dateTimeDelivery = dateTimeDelivery;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Product> getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	
}
