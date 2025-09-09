package br.com.gunthercloud.distributor.service;

import java.util.Optional;

import br.com.gunthercloud.distributor.mapper.SupplierMapper;
import br.com.gunthercloud.distributor.repository.SupplierRepository;
import br.com.gunthercloud.distributor.exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.dto.response.ProductDTO;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

	@Autowired
	private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper sMapper;

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable){

        Page<Product> list =  repository.findByActiveTrue(pageable);

		return list.map(x -> {
            ProductDTO dto = mapper.productToDTO(x);
            dto.setSupplier(sMapper.supplierToDTO(x.getSupplier()));
            return dto;
        });
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {

		Product entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));

        if(!entity.isActive()) throw new NotFoundException("Esse produto foi deletado!");

        ProductDTO dto = mapper.productToDTO(entity);
        dto.setSupplier(sMapper.supplierToDTO(entity.getSupplier()));
		return dto;
	}
	
	@Transactional
	public ProductDTO createProduct(ProductDTO dto) {

        Product entity = mapper.productToEntity(dto);
        entity.setId(null);

        Optional<Supplier> supFind = supplierRepository.findById(dto.getSupplier().getId());
        if(supFind.isEmpty()) throw new NotFoundException("Não foi possivel encontrar o id " + dto.getSupplier() + ".");

        entity.setSupplier(supFind.get());
		entity = repository.save(entity);

        ProductDTO result = mapper.productToDTO(entity);
        result.setSupplier(dto.getSupplier());

		return result;
	}

	@Transactional
	public ProductDTO updateProduct(Long id, ProductDTO dto) {

		repository.findById(id).orElseThrow(() -> new NotFoundException("O produto com o id " + id +  " não existe!"));
		Product entity = mapper.productToEntity(dto);
		entity.setId(id);

        Optional<Supplier> supFind = supplierRepository.findById(dto.getSupplier().getId());
        if(supFind.isEmpty()) throw new NotFoundException("Não foi possivel encontrar o fornecedor com o id " + dto.getSupplier() + ".");
		entity.setSupplier(supFind.get());

		entity = repository.save(entity);

        ProductDTO productDTO = mapper.productToDTO(entity);
        productDTO.setSupplier(sMapper.supplierToDTO(entity.getSupplier()));
		return productDTO;
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
