package br.com.gunthercloud.distributor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.distributor.entities.dto.DeliveryDTO;
import br.com.gunthercloud.distributor.services.DeliveryService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliveryResource {
	
	@Autowired
	private DeliveryService service;

	@GetMapping
	public ResponseEntity<List<DeliveryDTO>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DeliveryDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<DeliveryDTO> create(@RequestBody DeliveryDTO obj) {
		return ResponseEntity.status(201).body(service.create(obj));
	}

	@PutMapping
	public ResponseEntity<DeliveryDTO> update(Long id, DeliveryDTO obj) {
		return ResponseEntity.status(200).body(service.update(id, obj));
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}

}
