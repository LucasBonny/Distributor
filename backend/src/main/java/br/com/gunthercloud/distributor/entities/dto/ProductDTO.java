package br.com.gunthercloud.distributor.entities.dto;

import br.com.gunthercloud.distributor.entities.Product;

public class ProductDTO {
	
	private Long id;
	private Long barCode;
	private String name;
	private double price;
	private int stock;
	private String imgUrl;
	private String supplier;
	
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		barCode = entity.getBarCode();
		name = entity.getName();
		price = entity.getPrice();
		stock = entity.getStock();
		imgUrl = entity.getImgUrl();
		supplier = new SupplierDTO(entity.getSupplier()).getName();
	}
	
	public Long getId() {
		return id;
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

	public int getStock() {
		return stock;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getSupplier() {
		return supplier;
	}
	
}
