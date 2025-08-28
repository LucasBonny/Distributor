package br.com.gunthercloud.distributor.entities.dto;

import java.util.HashSet;
import java.util.Set;

public class SupplierWithProductsDTO extends SupplierDTO {

	private Set<ProductDTO> products = new HashSet<>();

	public Set<ProductDTO> getProducts() {
		return products;
	}
	
}
