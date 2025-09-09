package br.com.gunthercloud.distributor.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.distributor.dto.response.SupplierResponseDTO;
import br.com.gunthercloud.distributor.dto.response.SupplierWithProductsResponseDTO;
import br.com.gunthercloud.distributor.service.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
@CrossOrigin
public class SupplierController {

	@Autowired
	private SupplierService service;

//	@Autowired
//	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<SupplierResponseDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SupplierWithProductsResponseDTO> findById(@PathVariable UUID id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<SupplierResponseDTO> createSupplier(@RequestBody SupplierResponseDTO supplier) {
		return ResponseEntity.status(201).body(service.createSupplier(supplier));
	}

    @PostMapping(value = "/product")
    public ResponseEntity<SupplierWithProductsResponseDTO> createSupplierWithProducts(@RequestBody SupplierWithProductsResponseDTO supplier) {
        return ResponseEntity.ok().body(service.createSupplierWithProducts(supplier));
    }

    @PutMapping(value = "/{id}")
	public ResponseEntity<SupplierResponseDTO> updateSupplier(@PathVariable UUID id, @RequestBody SupplierResponseDTO obj){
		return ResponseEntity.ok().body(service.updateSupplier(id, obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteSupplier(@PathVariable UUID id) {
		service.deleteSupplier(id);
		return ResponseEntity.noContent().build();
	}

    @GetMapping("/names")
    public ResponseEntity<List<String>> findAllSupplierByName() {
        return ResponseEntity.ok().body(service.findAllSupplierByName());
    }
	
//	// Buscar todos os produtos entregues pela empresa
//	@GetMapping(value = "/{id}/products")
//	public List<ProductSearchDTO> findAllProductsBySupplierId(@PathVariable UUID id) {
//		return productService.findAllProductsBySupplierId(id);
//	}
//
//	// Buscar todas as entregas feita pela empresa tal
//	@GetMapping(value = "/{id}/deliveries")
//	public List<ProductDeliveryDTO> findDeliveriesBySupplierId(@PathVariable UUID id) {
//		return productService.findDeliveriesBySupplierId(id);
//	}
}
