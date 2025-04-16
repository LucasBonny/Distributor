package br.com.gunthercloud.project.entities.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.project.entities.Delivery;
import br.com.gunthercloud.project.entities.Product;

public class DeliveryDTO extends DeliveryMinDTO {
	
	private List<Product> productsDelivered;
	
	public DeliveryDTO () {
		
	}
	
	public DeliveryDTO (Delivery object) {
		BeanUtils.copyProperties(object, this);
	}
	
	public List<Product> getProductsDelivered() {
		return productsDelivered;
	}

	
	
}
