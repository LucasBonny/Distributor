package br.com.gunthercloud.distributor.entities.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import br.com.gunthercloud.distributor.entities.Delivery;
import br.com.gunthercloud.distributor.entities.Product;

public class DeliveryDTO {
	
	private Long id;
	private Instant dateTimeDelivery;
	private final String supplier;

	private final List<ProductDTO> products = new ArrayList<>();

	public DeliveryDTO (Delivery object) {
		id = object.getId();
		dateTimeDelivery = object.getDateTimeDelivery();
		supplier = object.getSupplier().getName();
		for(Product e : object.getProducts()) products.add(new ProductDTO(e));
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

	public String getSupplier() {
		return supplier;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}
	
}
