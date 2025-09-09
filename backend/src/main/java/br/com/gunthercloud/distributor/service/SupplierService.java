package br.com.gunthercloud.distributor.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
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
    private SupplierMapper mapper;

    @Autowired
    private ProductMapper pMapper;

	@Autowired
	private ProductRepository pRepository;
	
	@Transactional(readOnly = true)
	public List<SupplierDTO> findAll(){
		List<Supplier> emp = repository.findAll(Sort.by(Sort.Direction.ASC,"name"));
		return emp.stream().map(mapper::supplierToDTO).toList();
	}
	
	@Transactional(readOnly = true)
	public SupplierWithProductsDTO findById(UUID id) {
		Supplier entity = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id informado " + id + " não existe."));

		List<Product> products = pRepository.findBySupplier(entity);

        SupplierWithProductsDTO response = new SupplierWithProductsDTO();
        BeanUtils.copyProperties(entity, response);

        products.stream().map(pMapper::productToDTO).forEach(response.getProducts()::add);
		return response;
	}

	@Transactional
	public SupplierDTO createSupplier(SupplierDTO obj) {
		Supplier entity = mapper.supplierToEntity(obj);
		entity.setId(null);
		entity = repository.save(entity);
		return mapper.supplierToDTO(entity);
	}
	
	@Transactional
	public SupplierDTO updateSupplier(UUID id, SupplierDTO obj) {
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe."));
		Supplier entity = mapper.supplierToEntity(obj);
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
			throw new DatabaseExecption("Essa empresa tem produtos vinculados a ela.");
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

    // todo mudar a lógica do modo de salvar refatorar com o novo metodo do Supplier
    @Transactional
	public SupplierWithProductsDTO createSupplierWithProducts(SupplierWithProductsDTO supplier) {
		Supplier entity = mapper.supplierToEntity(supplier);
		entity.setId(null);

        entity = repository.save(entity);

        for(ProductDTO p : supplier.getProducts()) {
            Product prod = pMapper.productToEntity(p);
            prod.setSupplier(entity);
            prod = pRepository.save(prod);
            entity.getProducts().add(prod);
        }

        entity = repository.save(entity);

        SupplierWithProductsDTO supWith = new SupplierWithProductsDTO();
        BeanUtils.copyProperties(entity, supWith);

        Set<ProductDTO> prodDTOs = new HashSet<>();
        for(Product dto : entity.getProducts())
            prodDTOs.add(pMapper.productToDTO(dto));
        supWith.setProducts(prodDTOs);
		return supWith;
	}

    @Transactional
    public List<String> findAllSupplierByName() {
        List<Supplier> supplier = repository.findAll();
        List<String> list = new ArrayList<>();
        for(Supplier e : supplier) {
            list.add(e.getName());
        }
        return list.stream().sorted().toList();
    }
	
}
