package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Product;

public class ProductSearchDTO {
	
	private Long barCode;
	private String name;
	private double price;
	private int quantity;

	public ProductSearchDTO() {
		
	}
	public ProductSearchDTO(Product entity) {
		barCode = entity.getBarCode();
		name = entity.getName();
		price = entity.getPrice();
		quantity = entity.getStock();
	}
	
	public int getQuantity() {
		return quantity;
	}
	public Long getBarCode() {
		return barCode;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	
}
