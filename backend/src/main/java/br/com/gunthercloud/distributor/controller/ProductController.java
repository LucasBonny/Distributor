package br.com.gunthercloud.distributor.controller;

import java.util.List;

import br.com.gunthercloud.distributor.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gunthercloud.distributor.entity.dto.ProductDTO;
import br.com.gunthercloud.distributor.service.ProductService;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(service.findById(id));
        }
        catch (NotFoundException e) {
            throw new NotFoundException("Id " + id + " doesn't exist!");
        }
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO obj) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Houve um erro ao criar o usuário");
        }
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO obj) {
		return ResponseEntity.ok().body(service.update(id, obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}

	@GetMapping(value = "/suppliers")
	public ResponseEntity<List<String>> findAllSupplier() {
		return ResponseEntity.ok().body(service.findAllSupplier());
	}

}
