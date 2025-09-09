package br.com.gunthercloud.distributor.entity.dto;

import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryItemDTO {

    private Long id;
    private int quantity;
    private double unitPrice;
    private ProductDTO product;
    private DeliveryDTO delivery;

}
