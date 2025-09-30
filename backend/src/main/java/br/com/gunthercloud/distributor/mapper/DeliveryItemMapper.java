package br.com.gunthercloud.distributor.mapper;

import br.com.gunthercloud.distributor.dto.request.DeliveryItemRequestDTO;
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
        dto.setProduct(entity.getProduct().getId());
        return dto;
    }
    public DeliveryItemResponseDTO deliveryItemToDTO(DeliveryItem entity) {
        DeliveryItemResponseDTO dto = new DeliveryItemResponseDTO();

        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setProduct(entity.getProduct().getId());
        dto.setDeliveryId(entity.getDelivery().getId());
        return dto;
    }

    public DeliveryItem deliveryItemToEntity(DeliveryItemRequestDTO dto) {

        DeliveryItem entity = new DeliveryItem();

        BeanUtils.copyProperties(dto, entity);

        return entity;
    }
}
