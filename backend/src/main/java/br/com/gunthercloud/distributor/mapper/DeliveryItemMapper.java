package br.com.gunthercloud.distributor.mapper;

import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseSimpleDTO;
import br.com.gunthercloud.distributor.entity.DeliveryItem;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryItemMapper {

    @Autowired
    private ProductMapper productMapper;

    public DeliveryItemResponseSimpleDTO deliveryItemToSimpleDTO(DeliveryItem entity) {
        DeliveryItemResponseSimpleDTO dto = new DeliveryItemResponseSimpleDTO();

        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setProduct(productMapper.productToDTO(entity.getProduct()));
        return dto;
    }
    public DeliveryItemResponseSimpleDTO deliveryItemToDTO(DeliveryItem entity) {
        DeliveryItemResponseSimpleDTO dto = new DeliveryItemResponseSimpleDTO();

        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setProduct(productMapper.productToDTO(entity.getProduct()));
        return dto;
    }

    public DeliveryItem deliveryItemToEntity(DeliveryItemResponseDTO dto) {

        DeliveryItem entity = new DeliveryItem();

        BeanUtils.copyProperties(dto, entity);

        return entity;
    }
}
