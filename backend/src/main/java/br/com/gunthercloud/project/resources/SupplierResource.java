package br.com.gunthercloud.project.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import br.com.gunthercloud.project.entities.dto.SupplierDTO;
import br.com.gunthercloud.project.entities.dto.SupplierMinDTO;
import br.com.gunthercloud.project.services.SupplierService;

@RestController
@RequestMapping(value = "/suppliers")
@CrossOrigin
public class SupplierResource {

	@Autowired
	private SupplierService service;

//	@Autowired
//	private ProductService productService;

	@GetMapping
	public ResponseEntity<Page<SupplierDTO>> findAllPaged(@PageableDefault(size = 100) Pageable pageable) {
		return ResponseEntity.ok().body(service.findAllPaged(pageable));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SupplierDTO> findById(@PathVariable UUID id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<SupplierDTO> create(@RequestBody SupplierDTO supplier) {
		return ResponseEntity.status(201).body(service.create(supplier));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<SupplierDTO> update(@PathVariable UUID id, @RequestBody SupplierDTO obj){
		return ResponseEntity.ok().body(service.update(id, obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
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
