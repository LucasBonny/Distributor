package br.com.gunthercloud.distributor.mapper;

import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.entity.dto.DeliveryDTO;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {

    private final SupplierMapper supplierMapper;
    private final ProductMapper productMapper;

    public DeliveryMapper(SupplierMapper supplierMapper, ProductMapper productMapper) {
        this.supplierMapper = supplierMapper;
        this.productMapper = productMapper;
    }

    public DeliveryDTO deliveryToDTO(Delivery entity) {
        DeliveryDTO dto = new DeliveryDTO();

        dto.setDateTimeDelivery(entity.getDateTimeDelivery());
        dto.setId(entity.getId());

//        entity.getProducts().forEach(x -> {
//           dto.getProducts().add(productMapper.productToDTO(x).getId());
//        });

//        dto.setSupplier(entity.getSupplier().getId());

        return dto;
    }

    public Delivery deliveryToEntity(DeliveryDTO dto) {

        Delivery entity = new Delivery();

        entity.setId(dto.getId());
        entity.setDateTimeDelivery(dto.getDateTimeDelivery());

        return entity;
    }
}
