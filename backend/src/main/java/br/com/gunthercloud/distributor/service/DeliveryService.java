package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.dto.request.DeliveryItemRequestDTO;
import br.com.gunthercloud.distributor.dto.request.DeliveryRequestDTO;
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
import br.com.gunthercloud.distributor.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    @Autowired
    private DeliveryMapper mapper;

    @Autowired
    private DeliveryItemMapper deliveryItemMapper;

    @Autowired
    private DeliveryItemService deliveryItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

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
	public DeliveryResponseDTO createDelivery(DeliveryRequestDTO obj) {
		Delivery entity = mapper.deliveryRequestToEntity(obj);
        entity.setSupplier(supplierRepository.findById(UUID.fromString(obj.getSupplier())).orElseThrow(()
                -> new NotFoundException("Esse fornecedor não existe!")));

		entity.setId(null);

        Set<DeliveryItem> listItems = new HashSet<>();

        for(DeliveryItemRequestDTO diDTO : obj.getItems()) {
            DeliveryItem di = new DeliveryItem();

            di.setId(null);
            di.setQuantity(diDTO.getQuantity());
            di.setUnitPrice(diDTO.getUnitPrice());
            di.setProduct(productRepository.findById(diDTO.getProduct()).orElseThrow(()
                    -> new NotFoundException("O produto com o id " + diDTO.getProduct() + " não existe!")));
            di.setDelivery(entity);

            productService.increaseNewStock(diDTO.getProduct(), diDTO.getQuantity());

            listItems.add(di);
        }
        entity.setItems(listItems);
		entity = repository.save(entity);
		return mapper.deliveryToDTO(entity);
	}
	@Transactional
	public DeliveryResponseDTO updateDelivery(Long id, DeliveryRequestDTO obj) {
		repository.findById(id).orElseThrow(() ->
			new NotFoundException("O id " + id + " não existe."));
		Delivery entity = mapper.deliveryRequestToEntity(obj);
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

    // todo Buscar todas as entregas feita pela empresa tal
    // todo Buscar todos os produtos entregues pela empresa
}
