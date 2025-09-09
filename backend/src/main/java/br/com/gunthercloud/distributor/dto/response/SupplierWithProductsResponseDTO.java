package br.com.gunthercloud.distributor.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SupplierWithProductsResponseDTO extends SupplierResponseDTO {

	private Set<ProductResponseDTO> products = new HashSet<>();

}
