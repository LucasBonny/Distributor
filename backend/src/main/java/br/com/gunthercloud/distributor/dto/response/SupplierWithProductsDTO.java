package br.com.gunthercloud.distributor.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SupplierWithProductsDTO extends SupplierDTO {

	private Set<ProductDTO> products = new HashSet<>();

}
