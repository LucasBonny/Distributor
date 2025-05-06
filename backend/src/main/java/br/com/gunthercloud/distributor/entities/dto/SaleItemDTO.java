package br.com.gunthercloud.distributor.entities.dto;

import br.com.gunthercloud.distributor.entities.SaleItem;

public class SaleItemDTO {
	
	private Long product;
	private Long sale;
	private int quantity;
	private double price;
	
	public SaleItemDTO(SaleItem entity) {
		product = entity.getId().getProduct().getBarCode();
		sale = entity.getId().getSale().getId();
		quantity = entity.getQuantity();
		price = entity.getPrice();
	}
	
	public Long getProduct() {
		return product;
	}

	public Long getSale() {
		return sale;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}

}
