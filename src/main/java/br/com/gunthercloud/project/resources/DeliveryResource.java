package br.com.gunthercloud.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
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

import br.com.gunthercloud.project.entities.dto.DeliveryDTO;
import br.com.gunthercloud.project.entities.dto.DeliveryMinDTO;
import br.com.gunthercloud.project.services.DeliveryService;

@RestController
@RequestMapping(value = "/deliveries")
@CrossOrigin
public class DeliveryResource implements ResourceModel<DeliveryDTO, DeliveryMinDTO, Long>{
	
	@Autowired
	private DeliveryService service;

	@Override
	@GetMapping
	public ResponseEntity<Page<DeliveryMinDTO>> findAllPaged(@PageableDefault(sort = "dateTimeDelivery", 
						size = 10, direction = Direction.ASC) Pageable pageable){
		return ResponseEntity.ok().body(service.findAllPaged(pageable));
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<DeliveryDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@Override
	@PostMapping
	public ResponseEntity<DeliveryDTO> create(@RequestBody DeliveryDTO obj) {
		return ResponseEntity.status(201).body(service.create(obj));
	}

	@Override
	@PutMapping
	public ResponseEntity<DeliveryDTO> update(Long id, DeliveryDTO obj) {
		return ResponseEntity.status(200).body(service.update(id, obj));
	}

	@Override
	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}

}
