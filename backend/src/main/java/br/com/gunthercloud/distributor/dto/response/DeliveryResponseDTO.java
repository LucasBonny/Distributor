package br.com.gunthercloud.distributor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponseDTO {

    private Long id;
    private Instant dateTimeDelivery;
	private SupplierResponseDTO supplier;
    private Set<DeliveryItemResponseDTO> items = new HashSet<>();

}
