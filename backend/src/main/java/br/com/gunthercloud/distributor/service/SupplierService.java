package br.com.gunthercloud.distributor.service;

import br.com.gunthercloud.distributor.dto.request.SupplierRequestDTO;
import br.com.gunthercloud.distributor.dto.response.SupplierResponseDTO;
import br.com.gunthercloud.distributor.dto.response.SupplierResponseSimpleDTO;
import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.exceptions.DatabaseException;
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
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.UUID;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository repository;

    @Autowired
    private SupplierMapper mapper;

    @Autowired
    private ProductMapper pMapper;

	@Autowired
	private ProductRepository pRepository;
	
	@Transactional(readOnly = true)
	public Page<SupplierResponseSimpleDTO> findAll(Pageable pageable){

        Page<Supplier> list = repository.findAll(pageable);
		return list.map(mapper::supplierToDTOSimple);
	}
	
	@Transactional(readOnly = true)
	public SupplierResponseDTO findById(UUID id) {
		Supplier entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id informado " + id + " não existe."));

        // todo fazer outra forma de buscar os produtos de um fornecedor
//		List<Product> products = pRepository.findBySupplier(entity);
//      SupplierWithProductsResponseDTO response = new SupplierWithProductsResponseDTO();
//      BeanUtils.copyProperties(entity, response);
//      products.stream().map(pMapper::productToDTO).forEach(response.getProducts()::add);
//		return response;
        return mapper.supplierToDTO(entity);
	}

	@Transactional
	public SupplierResponseDTO createSupplier(SupplierRequestDTO requestDTO) {
		Supplier entity = mapper.supplierToEntity(requestDTO);
		entity.setId(null);
        if(!entity.getProducts().isEmpty())
            for(Product product : entity.getProducts())
                entity.addProduct(product);
		entity = repository.save(entity);
		return mapper.supplierToDTO(entity);
	}
	
	@Transactional
	public SupplierResponseDTO updateSupplier(UUID id, SupplierRequestDTO requestDTO) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		Supplier entity = mapper.supplierToEntity(requestDTO);
		entity.setId(id);
		entity = repository.save(entity);
		return mapper.supplierToDTO(entity);
	}

	@Transactional
	public void deleteSupplier(UUID id) {
		try {
			repository.findById(id).orElseThrow(() -> 
				new NotFoundException("O id " + id + " não existe."));
			repository.deleteById(id);			
		}
		catch(MethodArgumentTypeMismatchException e) {
			throw new DatabaseException("Essa empresa tem produtos vinculados a ela.");
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

    // todo mudar a lógica do modo de salvar refatorar com o novo metodo do Supplier
//    @Transactional
//	public SupplierWithProductsResponseDTO createSupplierWithProducts(SupplierRequestDTO requestDTO) {
//		Supplier entity = mapper.supplierToEntity(requestDTO);
//		entity.setId(null);
//
//        entity = repository.save(entity);
//
//        for(ProductResponseDTO p : supplier.getProducts()) {
//            Product prod = pMapper.productToEntity(p);
//            prod.setSupplier(entity);
//            prod = pRepository.save(prod);
//            entity.getProducts().add(prod);
//        }
//
//        entity = repository.save(entity);
//
//        SupplierWithProductsResponseDTO supWith = new SupplierWithProductsResponseDTO();
//        BeanUtils.copyProperties(entity, supWith);
//
//        Set<ProductResponseDTO> prodDTOs = new HashSet<>();
//        for(Product dto : entity.getProducts())
//            prodDTOs.add(pMapper.productToDTO(dto));
//        supWith.setProducts(prodDTOs);
//		return supWith;
//	}

    // todo consultar pelos dados da empresa
//    @Transactional
//    public List<String> findAllSupplierByName() {
//        List<Supplier> supplier = repository.findAll();
//        List<String> list = new ArrayList<>();
//        for(Supplier e : supplier) {
//            list.add(e.getName());
//        }
//        return list.stream().sorted().toList();
//    }
	
}
