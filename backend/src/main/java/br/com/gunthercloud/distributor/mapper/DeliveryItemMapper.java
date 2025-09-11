package br.com.gunthercloud.distributor.mapper;

import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseSimpleDTO;
import br.com.gunthercloud.distributor.entity.DeliveryItem;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DeliveryItemMapper {

    public DeliveryItemResponseSimpleDTO deliveryItemToSimpleDTO(DeliveryItem entity) {
        DeliveryItemResponseSimpleDTO dto = new DeliveryItemResponseSimpleDTO();

        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        return dto;
    }
    public DeliveryItemResponseDTO deliveryItemToDTO(DeliveryItem entity) {
        DeliveryItemResponseDTO dto = new DeliveryItemResponseDTO();

        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        return dto;
    }

    public DeliveryItem deliveryItemToEntity(DeliveryItemResponseDTO dto) {

        DeliveryItem entity = new DeliveryItem();

        BeanUtils.copyProperties(dto, entity);

        return entity;
    }
}
