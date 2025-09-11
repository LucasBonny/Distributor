package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseSimpleDTO;
import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.entity.DeliveryItem;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseDTO;
import br.com.gunthercloud.distributor.exceptions.NotFoundException;
import br.com.gunthercloud.distributor.mapper.DeliveryItemMapper;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.repository.DeliveryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Page<DeliveryItemResponseSimpleDTO> findAll(Pageable pageable){
		return repository.findAll(pageable).map(deliveryItemMapper::deliveryItemToSimpleDTO);
	}
	
	@Transactional(readOnly = true)
	public DeliveryItemResponseSimpleDTO findById(Long id) {
		DeliveryItem deliveryItem = repository.findById(id).orElseThrow(()
				-> new NotFoundException("O id " + id + " não existe."));
		return deliveryItemMapper.deliveryItemToSimpleDTO(deliveryItem);
	}

//	@Transactional
//	public DeliveryDTO create(DeliveryDTO obj) {
//		Delivery entity = mapper.deliveryToEntity(obj);
//		entity.setId(null);
//		entity = repository.save(entity);
//		return mapper.deliveryToDTO(entity);
//	}
//	@Transactional
//	public DeliveryDTO update(Long id, DeliveryDTO obj) {
//		repository.findById(id).orElseThrow(() ->
//			new NotFoundException("O id " + id + " não existe."));
//		Delivery entity = mapper.deliveryToEntity(obj);
//		entity.setId(id);
//		entity = repository.save(entity);
//        return mapper.deliveryToDTO(entity);
//	}
//	@Transactional
//	public void delete(Long id) {
//		try {
//			Delivery entity = repository.findById(id).orElseThrow(() ->
//				new NotFoundException("O id " + id + " não existe!"));
//			repository.delete(entity);
//		}
//		catch(DataIntegrityViolationException e) {
//			throw new DatabaseException(e.getMessage());
//		}
//
//	}
}
