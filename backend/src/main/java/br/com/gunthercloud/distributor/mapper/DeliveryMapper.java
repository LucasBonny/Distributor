package br.com.gunthercloud.distributor.mapper;

import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {

    private final SupplierMapper supplierMapper;
    private final ProductMapper productMapper;

    public DeliveryMapper(SupplierMapper supplierMapper, ProductMapper productMapper) {
        this.supplierMapper = supplierMapper;
        this.productMapper = productMapper;
    }

    public DeliveryResponseDTO deliveryToDTO(Delivery entity) {
        DeliveryResponseDTO dto = new DeliveryResponseDTO();

        dto.setDateTimeDelivery(entity.getDeliveryDate());
        dto.setId(entity.getId());

//        entity.getProducts().forEach(x -> {
//           dto.getProducts().add(productMapper.productToDTO(x).getId());
//        });

//        dto.setSupplier(entity.getSupplier().getId());

        return dto;
    }

    public Delivery deliveryToEntity(DeliveryResponseDTO dto) {

        Delivery entity = new Delivery();

        entity.setId(dto.getId());
        entity.setDeliveryDate(dto.getDateTimeDelivery());

        return entity;
    }
}
