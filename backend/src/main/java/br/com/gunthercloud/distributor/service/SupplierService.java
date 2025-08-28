package br.com.gunthercloud.distributor.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.entity.dto.ProductDTO;
import br.com.gunthercloud.distributor.entity.dto.SupplierDTO;
import br.com.gunthercloud.distributor.entity.dto.SupplierWithProductsDTO;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.mapper.SupplierMapper;
import br.com.gunthercloud.distributor.repository.ProductRepository;
import br.com.gunthercloud.distributor.repository.SupplierRepository;
import br.com.gunthercloud.distributor.service.exceptions.DatabaseExecption;
import br.com.gunthercloud.distributor.service.exceptions.NotFoundException;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository repository;
	
	@Autowired
	private ProductRepository pRepository;
	
	@Transactional(readOnly = true)
	public List<SupplierDTO> findAll(){
		List<Supplier> emp = repository.findAll(Sort.by(Sort.Direction.ASC,"name"));
		return emp.stream().map(SupplierMapper::toDTO).toList();
	}
	
	@Transactional(readOnly = true)
	public SupplierWithProductsDTO findById(UUID id) {
		Supplier entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		List<Product> products = pRepository.findAll();
		for(Product p : products) 
			if(p.getSupplier().getId() == entity.getId()) entity.getProducts().add(p);
		return SupplierMapper.toDTOWithProducts(entity);
	}

	@Transactional
	public SupplierDTO create(SupplierDTO obj) {
		Supplier entity = SupplierMapper.toEntity(obj);
		entity.setId(null);
		entity = repository.save(entity);
		return SupplierMapper.toDTO(entity);
	}
	
	@Transactional
	public SupplierDTO update(UUID id, SupplierDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		Supplier entity = SupplierMapper.toEntity(obj);
		entity.setId(id);
		entity = repository.save(entity);
		return SupplierMapper.toDTO(entity);
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
	
	@Transactional
	public SupplierWithProductsDTO createWithProducts(SupplierWithProductsDTO supplier) {
		Supplier entity = SupplierMapper.toEntityWithProducts(supplier);
		entity.setId(null);
		
		entity.getProducts().forEach(System.out::println);
		
		entity = repository.save(entity);
		
		entity.getProducts().forEach(System.out::println);
		return SupplierMapper.toDTOWithProducts(entity);
	}
	
}
