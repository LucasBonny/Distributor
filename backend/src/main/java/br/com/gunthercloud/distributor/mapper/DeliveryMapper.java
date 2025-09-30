package br.com.gunthercloud.distributor.mapper;

import br.com.gunthercloud.distributor.dto.request.DeliveryRequestDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseSimpleDTO;
import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.entity.DeliveryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {

    @Autowired
    private DeliveryItemMapper deliveryItemMapper;

    public DeliveryResponseSimpleDTO deliveryToSimpleDTO(Delivery entity) {

        DeliveryResponseSimpleDTO dto = new DeliveryResponseSimpleDTO();

        dto.setDeliveryDate(entity.getDeliveryDate());
        dto.setId(entity.getId());
        dto.setSupplier(entity.getSupplier().getId());

        return dto;
    }
    public DeliveryResponseDTO deliveryToDTO(Delivery entity) {

        DeliveryResponseDTO dto = new DeliveryResponseDTO();

        dto.setDeliveryDate(entity.getDeliveryDate());
        dto.setId(entity.getId());
        dto.setSupplier(entity.getSupplier().getId());

        for(DeliveryItem di : entity.getItems())
            dto.getItems().add(deliveryItemMapper.deliveryItemToDTO(di));

        return dto;
    }

    public Delivery deliveryRequestToEntity(DeliveryRequestDTO dto) {

        Delivery entity = new Delivery();

        entity.setId(dto.getId());
        entity.setDeliveryDate(dto.getDeliveryDate());

        return entity;
    }
}
