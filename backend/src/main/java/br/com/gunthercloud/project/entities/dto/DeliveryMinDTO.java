package br.com.gunthercloud.project.entities.dto;

import java.time.Instant;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.project.entities.Delivery;
import br.com.gunthercloud.project.entities.Supplier;

public class DeliveryMinDTO {
	
	private Long id;
	private Instant dateTimeDelivery;
	private Supplier supplier;
	
	public DeliveryMinDTO () {
		
	}
	
	public DeliveryMinDTO (Delivery object) {
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
	
}
