package br.com.gunthercloud.project.resources;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.project.entities.dto.ProductDTO;
import br.com.gunthercloud.project.entities.dto.ProductMinDTO;
import br.com.gunthercloud.project.services.ProductService;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin
public class ProductResource implements ResourceModel<ProductDTO, ProductMinDTO, Long> {
	
	@Autowired
	private ProductService service;
	
	@Override
	@GetMapping
	public ResponseEntity<Page<ProductMinDTO>> findAllPaged(@PageableDefault(size = 10) Pageable pageable){
		Page<ProductMinDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@Override
	@PostMapping
	public ResponseEntity<ProductDTO> create(ProductDTO obj) {
		return ResponseEntity.status(201).body(service.create(obj));
	}

	@Override
	@PutMapping
	public ResponseEntity<ProductDTO> update(Long id, ProductDTO obj) {
		return ResponseEntity.ok().body(service.update(id, obj));
	}

	@Override
	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}
}
