package br.com.gunthercloud.distributor.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryItemRequestDTO {

    private Long id;
    private Integer quantity;
    private Double unitPrice;
    private Long product;

}
