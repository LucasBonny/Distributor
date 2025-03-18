package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Product;

public class ProductDTO extends ProductMinDTO {
	
	private double price;
	private int stock;
	private String imgUrl;
	
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(Product entity) {
		super(entity);
		price = entity.getPrice();
		stock = entity.getStock();
		imgUrl = entity.getImgUrl();
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
