package br.com.gunthercloud.distributor.entity.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import br.com.gunthercloud.distributor.entity.Delivery;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDTO {

    private Long id;
    private Instant dateTimeDelivery;
	private final String supplier;

	private final List<ProductDTO> products = new ArrayList<>();

	public DeliveryDTO (Delivery object) {
		id = object.getId();
		dateTimeDelivery = object.getDateTimeDelivery();
		supplier = object.getSupplier().getName();
//		for(Product e : object.getProducts())
//			products.add(ProductMapper.toDTO(e));
	}
	
}
