package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.mapper.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseDTO;
import br.com.gunthercloud.distributor.repository.DeliveryRepository;
import br.com.gunthercloud.distributor.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.exceptions.NotFoundException;

@Service
@Transactional
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository repository;

    @Autowired
    private DeliveryMapper mapper;
	
	@Transactional(readOnly = true)
	public Page<DeliveryResponseDTO> findAll(Pageable pageable){
		Page<Delivery> emp = repository.findAll(pageable);
		return emp.map(mapper::deliveryToDTO);
	}
	
	@Transactional(readOnly = true)
	public DeliveryResponseDTO findById(Long id) {
		Delivery emp = repository.findById(id).orElseThrow(() 
				-> new NotFoundException("O id " + id + " não existe."));
		return mapper.deliveryToDTO(emp);
	}
	
	@Transactional
	public DeliveryResponseDTO create(DeliveryResponseDTO obj) {
		Delivery entity = mapper.deliveryToEntity(obj);
		entity.setId(null);
		entity = repository.save(entity);
		return mapper.deliveryToDTO(entity);
	}
	@Transactional
	public DeliveryResponseDTO update(Long id, DeliveryResponseDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		Delivery entity = mapper.deliveryToEntity(obj);
		entity.setId(id);
		entity = repository.save(entity);
        return mapper.deliveryToDTO(entity);
	}
	@Transactional
	public void delete(Long id) {
		try {
			Delivery entity = repository.findById(id).orElseThrow(() -> 
				new NotFoundException("O id " + id + " não existe!"));
			repository.delete(entity);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
}
