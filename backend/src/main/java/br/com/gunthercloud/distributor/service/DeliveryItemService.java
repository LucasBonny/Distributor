package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.entity.DeliveryItem;
import br.com.gunthercloud.distributor.dto.response.DeliveryDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryItemDTO;
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
    private ProductMapper pMapper;
	
	@Transactional(readOnly = true)
	public Page<DeliveryItemDTO> findAll(Pageable pageable){
		Page<DeliveryItem> emp = repository.findAll(pageable);
		return emp.map(x -> {
            return new DeliveryItemDTO(x.getId(), x.getQuantity(), x.getUnitPrice(), pMapper.productToDTO(x.getProduct()),new DeliveryDTO());
        });
	}
	
//	@Transactional(readOnly = true)
//	public DeliveryDTO findById(Long id) {
//		Delivery emp = repository.findById(id).orElseThrow(()
//				-> new NotFoundException("O id " + id + " não existe."));
//		return mapper.deliveryToDTO(emp);
//	}
//
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
