package br.com.gunthercloud.distributor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gunthercloud.distributor.repository.SupplierRepository;
import br.com.gunthercloud.distributor.service.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.service.exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.entity.dto.ProductDTO;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private SupplierRepository supplierRepository;

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> list =  repository.findAll(pageable);
		return list.map(ProductMapper::toDTO);
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));
		return ProductMapper.toDTO(entity);
	}
	
	@Transactional
	public ProductDTO createProduct(ProductDTO obj) {
        Product entity = ProductMapper.toEntity(obj);
        entity.setId(null);
        Optional<Supplier> sup = supplierRepository.findById(obj.getSupplier());
        entity.setSupplier(sup.orElseThrow());
		entity = repository.save(entity);
		return ProductMapper.toDTO(entity);
	}

	@Transactional
	public ProductDTO updateProduct(Long id, ProductDTO obj) {
		repository.findById(id).orElseThrow(() ->
			new NotFoundException("O id " + id +  " não existe!"));
		Product entity = ProductMapper.toEntity(obj);
		entity.setId(id);
		// entity.setSupplier(supplierRepository.findByName(obj.getSupplier()));
		entity = repository.save(entity);
		return ProductMapper.toDTO(entity);
	}

	@Transactional
	public void deleteProduct(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
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
