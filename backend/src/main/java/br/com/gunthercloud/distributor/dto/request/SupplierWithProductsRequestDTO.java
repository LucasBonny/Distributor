package br.com.gunthercloud.distributor.dto.request;

import br.com.gunthercloud.distributor.dto.response.SupplierResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SupplierWithProductsRequestDTO extends SupplierResponseDTO {

	private Set<ProductRequestDTO> products = new HashSet<>();

}
