package br.com.gunthercloud.distributor.entity.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.gunthercloud.distributor.entity.Delivery;
import lombok.*;

@Data
public class DeliveryDTO {

    private Long id;
    private Instant dateTimeDelivery;
	private UUID supplier;
	private List<Long> products;

}
