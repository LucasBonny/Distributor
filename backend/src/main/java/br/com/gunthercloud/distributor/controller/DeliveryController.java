package br.com.gunthercloud.distributor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.gunthercloud.distributor.dto.response.DeliveryResponseDTO;
import br.com.gunthercloud.distributor.service.DeliveryService;

@RestController
@RequestMapping(value = "/delivery")
@CrossOrigin
public class DeliveryController {
	
	@Autowired
	private DeliveryService service;

	@GetMapping
	public ResponseEntity<Page<DeliveryResponseDTO>> findAll(Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DeliveryResponseDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<DeliveryResponseDTO> create(@RequestBody DeliveryResponseDTO obj) {
		return ResponseEntity.status(201).body(service.create(obj));
	}

	@PutMapping
	public ResponseEntity<DeliveryResponseDTO> update(Long id, DeliveryResponseDTO obj) {
		return ResponseEntity.status(200).body(service.update(id, obj));
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}

}
