package br.com.gunthercloud.distributor.dto.request;

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
public class DeliveryRequestDTO {

    private Long id;
    private Instant deliveryDate;
	private String supplier;
    private Set<DeliveryItemRequestDTO> items = new HashSet<>();

}
