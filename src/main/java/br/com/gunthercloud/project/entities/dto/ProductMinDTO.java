package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Product;

public class ProductMinDTO {
	private Long barCode;
	private String name;
	
	public ProductMinDTO() {
		
	}
	public ProductMinDTO(Product entity) {
		barCode = entity.getBarCode();
		name = entity.getName();
	}
	public Long getBarCode() {
		return barCode;
	}
	public String getName() {
		return name;
	}

}
