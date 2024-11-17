package br.com.gunthercloud.project.entities.dto;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gunthercloud.project.entities.Product;
import br.com.gunthercloud.project.entities.pk.DeliveryGoodsPK;

public class DeliveryGoodsMinPK {
	
	@Autowired
	private Product product;

	public DeliveryGoodsMinPK() {
		
	}
	public DeliveryGoodsMinPK(DeliveryGoodsPK entity) {
		product = entity.getProduct();
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	
	
}
