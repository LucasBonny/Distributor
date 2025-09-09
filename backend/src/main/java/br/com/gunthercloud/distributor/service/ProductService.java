package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.dto.request.ProductRequestDTO;
import br.com.gunthercloud.distributor.dto.response.ProductResponseDTO;
import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.exceptions.NotFoundException;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.mapper.SupplierMapper;
import br.com.gunthercloud.distributor.repository.ProductRepository;
import br.com.gunthercloud.distributor.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
	public Page<ProductResponseDTO> findAll(Pageable pageable){

        Page<Product> list =  repository.findByActiveTrue(pageable);

		return list.map(x -> {
            ProductResponseDTO dto = mapper.productToDTO(x);
            dto.setSupplier(sMapper.supplierToDTO(x.getSupplier()));
            return dto;
        });
	}
	
	@Transactional(readOnly = true)
	public ProductResponseDTO findById(Long id) {

		Product entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));

        if(!entity.isActive()) throw new NotFoundException("Esse produto foi deletado!");

        ProductResponseDTO dto = mapper.productToDTO(entity);
        dto.setSupplier(sMapper.supplierToDTO(entity.getSupplier()));
		return dto;
	}
	
	@Transactional
	public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {

        Product entity = mapper.productToEntity(requestDTO);
        entity.setId(null);

        Optional<Supplier> supFind = supplierRepository.findById(requestDTO.getSupplier());
        if(supFind.isEmpty()) throw new NotFoundException("Não foi possivel encontrar o id " + requestDTO.getSupplier() + ".");

        entity.setSupplier(supFind.get());
		entity = repository.save(entity);

        ProductResponseDTO result = mapper.productToDTO(entity);
        Supplier supplier = supplierRepository.findById(requestDTO.getSupplier()).orElseThrow(() -> new RuntimeException("Houve um erro ao buscar esse supplier_id."));
        result.setSupplier(sMapper.supplierToDTO(supplier));

		return result;
	}

	@Transactional
	public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) {

		repository.findById(id).orElseThrow(() -> new NotFoundException("O produto com o id " + id +  " não existe!"));
		Product entity = mapper.productToEntity(requestDTO);
		entity.setId(id);

        Optional<Supplier> supFind = supplierRepository.findById(requestDTO.getSupplier());
        if(supFind.isEmpty()) throw new NotFoundException("Não foi possivel encontrar o fornecedor com o id " + requestDTO.getSupplier() + ".");
		entity.setSupplier(supFind.get());

		entity = repository.save(entity);

        ProductResponseDTO productResponseDTO = mapper.productToDTO(entity);
        productResponseDTO.setSupplier(sMapper.supplierToDTO(entity.getSupplier()));
		return productResponseDTO;
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
