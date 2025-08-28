package br.com.gunthercloud.distributor.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.dto.DeliveryDTO;

@Entity
@Table(name = "tb_delivery")
public class Delivery implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dateTimeDelivery;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

	@ManyToMany(mappedBy = "delivery")
	private List<Product> products = new ArrayList<>();
	
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
