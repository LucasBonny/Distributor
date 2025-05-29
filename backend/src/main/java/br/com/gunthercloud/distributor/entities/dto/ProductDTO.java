package br.com.gunthercloud.distributor.entities.dto;

import br.com.gunthercloud.distributor.entities.Product;

public class ProductDTO {
	
	private Long id;
	private Long barCode;
	private String name;
	private double price;
	private int stock;
	private String imgUrl;
	private SupplierDTO supplierDTO;
	
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
















		supplierDTO = new SupplierDTO(entity.getSupplier());
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

	public SupplierDTO getSupplierDTO() {
		return supplierDTO;
	}
	
}
