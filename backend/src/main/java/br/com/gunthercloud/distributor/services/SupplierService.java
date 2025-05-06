package br.com.gunthercloud.distributor.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import br.com.gunthercloud.distributor.entities.Supplier;
import br.com.gunthercloud.distributor.entities.dto.SupplierDTO;
import br.com.gunthercloud.distributor.repository.SupplierRepository;
import br.com.gunthercloud.distributor.services.exceptions.DatabaseExecption;
import br.com.gunthercloud.distributor.services.exceptions.NotFoundException;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository repository;
	
	@Transactional(readOnly = true)
	public List<SupplierDTO> findAll(){
		List<Supplier> emp = repository.findAll();
		return emp.stream().map(SupplierDTO::new).toList();
	}
	
	@Transactional(readOnly = true)
	public SupplierDTO findById(UUID id) {
		Supplier entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		return new SupplierDTO(entity);
	}

	@Transactional
	public SupplierDTO create(SupplierDTO obj) {
		Supplier entity = new Supplier(obj);
		entity.setId(null);
		entity = repository.save(entity);
		return new SupplierDTO(entity);
	}
	
	@Transactional
	public SupplierDTO update(UUID id, SupplierDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		Supplier entity = new Supplier(obj);
		entity.setId(id);
		return new SupplierDTO(repository.save(entity));
	}

	@Transactional
	public void delete(UUID id) {
		try {
			repository.findById(id).orElseThrow(() -> 
				new NotFoundException("O id " + id + " não existe."));
			repository.deleteById(id);			
		}
		catch(MethodArgumentTypeMismatchException e) {
			throw new DatabaseExecption("Essa empresa tem produtos vinculados a ela.");
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
