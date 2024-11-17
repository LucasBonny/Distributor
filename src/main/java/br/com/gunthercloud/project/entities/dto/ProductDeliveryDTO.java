package br.com.gunthercloud.project.entities.dto;

import java.time.Instant;

import br.com.gunthercloud.project.entities.DeliveryGoods;

public class ProductDeliveryDTO {
	
	private String name;
	private int quantity;
	private Instant dateDelivery;
	private double price;

	public ProductDeliveryDTO() {
		
	}
	public ProductDeliveryDTO(DeliveryGoods entity) {
		name = entity.getProduct().getName();
		quantity = entity.getQuantity();
		dateDelivery = entity.getDateDelivery();
		price = entity.getPrice();
	}
	
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public Instant getDateDelivery() {
		return dateDelivery;
	}
	public double getPrice() {
		return price;
	}
	
}
