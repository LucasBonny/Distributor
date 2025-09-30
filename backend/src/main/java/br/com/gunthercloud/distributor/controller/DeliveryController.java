package br.com.gunthercloud.distributor.controller;

import br.com.gunthercloud.distributor.dto.request.DeliveryItemRequestDTO;
import br.com.gunthercloud.distributor.dto.request.DeliveryRequestDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryItemResponseSimpleDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseDTO;
import br.com.gunthercloud.distributor.dto.response.DeliveryResponseSimpleDTO;
import br.com.gunthercloud.distributor.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/deliveries")
@CrossOrigin
public class DeliveryController {
	
	@Autowired
	private DeliveryService service;

	@GetMapping
	public ResponseEntity<Page<DeliveryResponseSimpleDTO>> findAll(@PageableDefault(sort = "id") Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

    @GetMapping(value = "/{id}")
    public ResponseEntity<DeliveryResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

	@PostMapping
	public ResponseEntity<DeliveryResponseDTO> createDelivery(@RequestBody DeliveryRequestDTO obj) {
		return ResponseEntity.status(201).body(service.createDelivery(obj));
	}

	@PutMapping
	public ResponseEntity<DeliveryResponseDTO> updateDelivery(Long id, DeliveryRequestDTO obj) {
		return ResponseEntity.status(200).body(service.updateDelivery(id, obj));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteDelivery(Long id) {
		service.deleteDelivery(id);
		return ResponseEntity.status(204).build();
	}

    // Itens na lista
    @GetMapping(value = "/{id}/items")
    public ResponseEntity<List<DeliveryItemResponseSimpleDTO>> showDeliveryItems(@PathVariable Double id) {
        return ResponseEntity.ok().body(service.showDeliveredItems(id));
    }

    @PostMapping(value = "/{id}/items")
    public ResponseEntity<DeliveryItemResponseDTO> addItemAtList(@PathVariable Long id, @RequestBody DeliveryItemRequestDTO deliveryItem) {
        return ResponseEntity.ok().body(service.addItemAtList(id, deliveryItem));
    }

}
