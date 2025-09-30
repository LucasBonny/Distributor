package br.com.gunthercloud.distributor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryItemResponseSimpleDTO {

    private Long id;
    private int quantity;
    private double unitPrice;
    private Long product;

}
