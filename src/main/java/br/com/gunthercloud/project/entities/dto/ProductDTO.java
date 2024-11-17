package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Product;

public class ProductDTO {
	
	private Long barCode;
	private String name;
	private double price;
	private int stock;
	private String imgUrl;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Product entity) {
		barCode = entity.getBarCode();
		name = entity.getName();
		price = entity.getPrice();
		stock = entity.getStock();
		imgUrl = entity.getImgUrl();
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
