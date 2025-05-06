package br.com.gunthercloud.distributor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.distributor.entities.Delivery;
import br.com.gunthercloud.distributor.entities.dto.DeliveryDTO;
import br.com.gunthercloud.distributor.repository.DeliveryRepository;
import br.com.gunthercloud.distributor.services.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.services.exceptions.NotFoundException;

@Service
@Transactional
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository repository;
	
	@Transactional(readOnly = true)
	public List<DeliveryDTO> findAll(){
		List<Delivery> emp = repository.findAll();
		return emp.stream().map(DeliveryDTO::new).toList();
	}
	
	@Transactional(readOnly = true)
	public DeliveryDTO findById(Long id) {
		Delivery emp = repository.findById(id).orElseThrow(() 
				-> new NotFoundException("O id " + id + " não existe."));
		return new DeliveryDTO(emp);
	}
	
	@Transactional
	public DeliveryDTO create(DeliveryDTO obj) {
		Delivery entity = new Delivery(obj);
		entity.setId(null);
		entity = repository.save(entity);
		return new DeliveryDTO(entity);
	}
	@Transactional
	public DeliveryDTO update(Long id, DeliveryDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		Delivery entity = new Delivery(obj);
		entity.setId(id);
		entity = repository.save(entity);
		return new DeliveryDTO(entity);
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
