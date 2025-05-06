package br.com.gunthercloud.distributor.entities.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import br.com.gunthercloud.distributor.entities.Delivery;
import br.com.gunthercloud.distributor.entities.Product;
import br.com.gunthercloud.distributor.entities.Supplier;

public class DeliveryDTO {
	
	private Long id;
	private Instant dateTimeDelivery;
	private Supplier supplier;

	private List<Product> products = new ArrayList<>();
	
	public DeliveryDTO () {
		
	}
	
	public DeliveryDTO (Delivery object) {
		id = object.getId();
		dateTimeDelivery = object.getDateTimeDelivery();
		supplier = object.getSupplier();
		for(Product e : object.getProducts()) products.add(e);
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
	
}
