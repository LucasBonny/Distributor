package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseSimpleDTO;
import br.com.gunthercloud.distributor.entity.DeliveryItem;
import br.com.gunthercloud.distributor.mapper.DeliveryItemMapper;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.repository.DeliveryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryItemService {

    @Autowired
    private DeliveryItemRepository repository;

    @Autowired
    private DeliveryItemMapper deliveryItemMapper;

    @Autowired
    private ProductMapper pMapper;
	
	@Transactional(readOnly = true)
	public List<DeliveryItemResponseSimpleDTO> findByDeliveryId(Double id){
        List<DeliveryItem> deliveryItem = repository.findByDeliveryId(id);
        return deliveryItem.stream().map(deliveryItemMapper::deliveryItemToSimpleDTO).toList();
	}

    @Transactional
    protected DeliveryItem addItemAtList(DeliveryItem deliveryItem) {
        return deliveryItem;
    }
}
