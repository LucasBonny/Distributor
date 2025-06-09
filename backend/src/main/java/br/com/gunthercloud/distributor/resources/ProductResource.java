package br.com.gunthercloud.distributor.resources;

import java.util.List;
import java.util.Map;

import br.com.gunthercloud.distributor.entities.Supplier;
import br.com.gunthercloud.distributor.entities.dto.SupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gunthercloud.distributor.entities.dto.ProductDTO;
import br.com.gunthercloud.distributor.services.ProductService;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin
public class ProductResource {
	
	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		List<ProductDTO> list = service.findAll();
		for(ProductDTO e : list) System.out.println(e.getName());
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO obj) {
		return ResponseEntity.status(201).body(service.create(obj));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO obj) {
		return ResponseEntity.ok().body(service.update(id, obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}

	@GetMapping(value = "/suppliers")
	public ResponseEntity<List<String>> findAllSupplier() {
		return ResponseEntity.ok().body(service.findAllSupplier());
	}

}
