package br.com.gunthercloud.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.project.entities.Product;
import br.com.gunthercloud.project.entities.dto.ProductDTO;
import br.com.gunthercloud.project.entities.dto.ProductMinDTO;
import br.com.gunthercloud.project.repository.ProductRepository;
import br.com.gunthercloud.project.services.exceptions.DatabaseException;
import br.com.gunthercloud.project.services.exceptions.NotFoundException;

@Service
@Transactional
public class ProductService implements ServiceModel<ProductDTO, ProductMinDTO, Long>{

	@Autowired
	private ProductRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<ProductMinDTO> findAllPaged(Pageable pageable){
		Page<Product> list =  repository.findAll(pageable);
		return list.map(x -> new ProductMinDTO(x));
	}
	
	@Override
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));
		return new ProductDTO(entity);
	}

	@Override
	public ProductDTO create(ProductDTO obj) {
		Product entity = new Product(obj);
		entity.setId(null);
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

	@Override
	public ProductDTO update(Long id, ProductDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id +  " não existe!"));
		Product entity = new Product(obj);
		entity.setId(id);
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}


	@Override
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
	
	//Busca todos os produtos da empresa X
//	public List<ProductDTO> findAllProductsBySupplierId(UUID id){
//		//busca todos os produtos entregue
//		
//	}
	
}
