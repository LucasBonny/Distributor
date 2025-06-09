package br.com.gunthercloud.distributor.services;

import java.util.ArrayList;
import java.util.List;

import br.com.gunthercloud.distributor.entities.Supplier;
import br.com.gunthercloud.distributor.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.distributor.entities.Product;
import br.com.gunthercloud.distributor.entities.dto.ProductDTO;
import br.com.gunthercloud.distributor.repository.ProductRepository;
import br.com.gunthercloud.distributor.services.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.services.exceptions.NotFoundException;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private SupplierRepository supplierRepository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list =  repository.findAll(Sort.by(Sort.Direction.ASC,"name"));
		return list.stream().map(ProductDTO::new).toList();
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));
		return new ProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO create(ProductDTO obj) {
		Product entity = new Product(obj);
		entity.setSupplier(supplierRepository.findByName(obj.getSupplier()));
		entity.setId(null);
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id +  " não existe!"));
		Product entity = new Product(obj);
		entity.setId(id);
		entity.setSupplier(supplierRepository.findByName(obj.getSupplier()));
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional
	public void delete(Long id) {
		try {
			Product entity = repository.findById(id).orElseThrow(() -> 
				new NotFoundException("O id " + id + " não existe!"));
			repository.delete(entity);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

	@Transactional
	public List<String> findAllSupplier() {
		List<Supplier> supplier = supplierRepository.findAll();
		List<String> list = new ArrayList<>();
		for(Supplier e : supplier) {
			list.add(e.getName());
		}
		return list;
	}

	//Busca todos os produtos da empresa X
//	public List<ProductDTO> findAllProductsBySupplierId(UUID id){
//		//busca todos os produtos entregue
//		
//	}
	
}
