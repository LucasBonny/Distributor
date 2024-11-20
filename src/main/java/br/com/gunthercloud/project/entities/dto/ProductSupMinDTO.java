package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Product;

public class ProductSupMinDTO {
	
	private Long barCode;
	private String name;
	private double price;
	private int stock;
	private String imgUrl;
	
	private SupplierMinDTO supplier = new SupplierMinDTO();
	
	public ProductSupMinDTO() {
		
	}
	
	public ProductSupMinDTO(Product entity) {
		barCode = entity.getBarCode();
		name = entity.getName();
		price = entity.getPrice();
		stock = entity.getStock();
		imgUrl = entity.getImgUrl();
	}

	
	public void setSupplier(SupplierMinDTO supplier) {
		this.supplier = supplier;
	}

	public SupplierMinDTO getSupplier() {
		return supplier;
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
	

}
