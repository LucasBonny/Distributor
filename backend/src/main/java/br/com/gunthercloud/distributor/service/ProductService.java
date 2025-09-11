package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.dto.request.ProductRequestDTO;
import br.com.gunthercloud.distributor.dto.response.ProductResponseDTO;
import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.exceptions.NotFoundException;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

	@Autowired
	private SupplierService supplierService;

	@Transactional(readOnly = true)
	public Page<ProductResponseDTO> findAll(Pageable pageable){

        Page<Product> list =  repository.findByActiveTrue(pageable);

		return list.map(mapper::productToDTO);
	}
	
	@Transactional(readOnly = true)
	public ProductResponseDTO findById(Long id) {

		Product entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));

        if(!entity.isActive()) throw new NotFoundException("Esse produto foi deletado!");

        return mapper.productToDTO(entity);
	}
	
	@Transactional
	public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {

        Product entity = mapper.productToEntity(requestDTO);
        entity.setId(null);

        Supplier supplier = supplierService.findBySupplierId(requestDTO.getSupplier());
        entity.setSupplier(supplier);

		return mapper.productToDTO(repository.save(entity));
	}

	@Transactional
	public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) {

		repository.findById(id).orElseThrow(() -> new NotFoundException("O produto com o id " + id +  " não existe!"));
		Product entity = mapper.productToEntity(requestDTO);
		entity.setId(id);

        Supplier supplier = supplierService.findBySupplierId(requestDTO.getSupplier());
        entity.setSupplier(supplier);

		entity = repository.save(entity);

		return mapper.productToDTO(entity);
	}

	@Transactional
	public void deleteProduct(Long id) {
		try {
            Product prod = repository.findById(id).orElseThrow(() -> new NotFoundException("O id " + id + " não existe!"));
            prod.setActive(false);
			repository.save(prod);
		}
		catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

    //Busca todos os produtos da empresa X
//	public List<ProductDTO> findAllProductsBySupplierId(UUID id){
//		//busca todos os produtos entregue
//		
//	}
	
}
