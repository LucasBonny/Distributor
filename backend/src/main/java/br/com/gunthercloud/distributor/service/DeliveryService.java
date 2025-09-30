package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.dto.request.DeliveryItemRequestDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseSimpleDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseSimpleDTO;
import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.entity.DeliveryItem;
import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.exceptions.NotFoundException;
import br.com.gunthercloud.distributor.mapper.DeliveryItemMapper;
import br.com.gunthercloud.distributor.mapper.DeliveryMapper;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.repository.DeliveryItemRepository;
import br.com.gunthercloud.distributor.repository.DeliveryRepository;
import br.com.gunthercloud.distributor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    @Autowired
    private DeliveryItemRepository deliveryItemRepository;

    @Autowired
    private DeliveryMapper mapper;

    @Autowired
    private DeliveryItemMapper deliveryItemMapper;

    @Autowired
    private DeliveryItemService deliveryItemService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper pMapper;
	
	@Transactional(readOnly = true)
	public Page<DeliveryResponseSimpleDTO> findAll(Pageable pageable){
		Page<Delivery> emp = repository.findAll(pageable);
		return emp.map(mapper::deliveryToSimpleDTO);
	}
	
	@Transactional(readOnly = true)
	public DeliveryResponseDTO findById(Long id) {
		Delivery delivery = repository.findById(id).orElseThrow(()
				-> new NotFoundException("O id " + id + " não existe."));
		return mapper.deliveryToDTO(delivery);
	}
	
	@Transactional
	public DeliveryResponseDTO createDelivery(DeliveryResponseDTO obj) {
		Delivery entity = mapper.deliveryToEntity(obj);
		entity.setId(null);
		entity = repository.save(entity);
		return mapper.deliveryToDTO(entity);
	}
	@Transactional
	public DeliveryResponseDTO updateDelivery(Long id, DeliveryResponseDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		Delivery entity = mapper.deliveryToEntity(obj);
		entity.setId(id);
		entity = repository.save(entity);
        return mapper.deliveryToDTO(entity);
	}
	@Transactional
	public void deleteDelivery(Long id) {
		try {
			Delivery entity = repository.findById(id).orElseThrow(() -> 
				new NotFoundException("O id " + id + " não existe!"));
			repository.delete(entity);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

    public List<DeliveryItemResponseSimpleDTO> showDeliveredItems(Double id) {
        return deliveryItemService.findByDeliveryId(id);
    }

    @Transactional
    public DeliveryItemResponseDTO addItemAtList(Long deliveryId, DeliveryItemRequestDTO itemRequest) {

        Delivery delivery = repository.findById(deliveryId)
                .orElseThrow(() -> new NotFoundException("Não existe uma entrega com o id " + deliveryId +"."));

        Product product = productRepository.findById(itemRequest.getProduct())
                .orElseThrow(() -> new NotFoundException("Não existe um produto com o id " + itemRequest.getProduct() +"."));

        DeliveryItem di = new DeliveryItem();
        di.setProduct(product);
        di.setQuantity(itemRequest.getQuantity());
        di.setUnitPrice(itemRequest.getUnitPrice());

        delivery.addDeliveryItem(di);

        delivery = repository.save(delivery);

        DeliveryItem persistedItem = delivery.getItems().stream()
                .max(Comparator.comparing(DeliveryItem::getId))
                .orElseThrow(() -> new IllegalStateException("O item salvo não foi encontrado na entrega."));

        return deliveryItemMapper.deliveryItemToDTO(persistedItem);
    }
    // todo Buscar todas as entregas feita pela empresa tal
    // todo Buscar todos os produtos entregues pela empresa
}
