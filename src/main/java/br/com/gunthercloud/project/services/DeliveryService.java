package br.com.gunthercloud.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.project.entities.Delivery;
import br.com.gunthercloud.project.entities.dto.DeliveryDTO;
import br.com.gunthercloud.project.entities.dto.DeliveryMinDTO;
import br.com.gunthercloud.project.repository.DeliveryRepository;
import br.com.gunthercloud.project.services.exceptions.DatabaseException;
import br.com.gunthercloud.project.services.exceptions.NotFoundException;

@Service
@Transactional
public class DeliveryService implements ServiceModel<DeliveryDTO, DeliveryMinDTO, Long>{
	
	@Autowired
	private DeliveryRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<DeliveryMinDTO> findAllPaged(Pageable pageable){
		Page<Delivery> emp = repository.findAll(pageable);
		return emp.map(DeliveryMinDTO::new);
	}
	@Override
	@Transactional(readOnly = true)
	public DeliveryDTO findById(Long id) {
		Delivery emp = repository.findById(id).orElseThrow(() 
				-> new NotFoundException("O id " + id + " não existe."));
		return new DeliveryDTO(emp);
	}
	@Override
	public DeliveryDTO create(DeliveryDTO obj) {
		Delivery entity = new Delivery(obj);
		entity.setId(null);
		entity = repository.save(entity);
		return new DeliveryDTO(entity);
	}
	@Override
	public DeliveryDTO update(Long id, DeliveryDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		Delivery entity = new Delivery(obj);
		entity.setId(id);
		entity = repository.save(entity);
		return new DeliveryDTO(entity);
	}
	@Override
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
