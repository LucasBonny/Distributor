package br.com.gunthercloud.distributor.controller;

import br.com.gunthercloud.distributor.controller.pageable.PageModel;
import br.com.gunthercloud.distributor.controller.pageable.PagedResponse;
import br.com.gunthercloud.distributor.dto.request.SupplierRequestDTO;
import br.com.gunthercloud.distributor.dto.response.ProductResponseDTO;
import br.com.gunthercloud.distributor.dto.response.SupplierResponseDTO;
import br.com.gunthercloud.distributor.dto.response.SupplierResponseSimpleDTO;
import br.com.gunthercloud.distributor.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/suppliers")
@CrossOrigin
public class SupplierController {

	@Autowired
	private SupplierService service;

    @Autowired
    private PagedResponse<SupplierResponseSimpleDTO> response;

	@GetMapping
	public ResponseEntity<PageModel<SupplierResponseSimpleDTO>> findAll(@PageableDefault(sort = "name") Pageable pageable) {
        Page<SupplierResponseSimpleDTO> responseDTO = service.findAll(pageable);
        return ResponseEntity.ok().body(response.request(responseDTO));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SupplierResponseSimpleDTO> findById(@PathVariable UUID id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<SupplierResponseDTO> createSupplier(@RequestBody SupplierRequestDTO supplier) {
		return ResponseEntity.status(201).body(service.createSupplier(supplier));
	}

    @GetMapping(value = "{id}/products")
    public ResponseEntity<List<ProductResponseDTO>> findProductsBySupplierId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findProductsBySupplierId(id));
    }

    @PutMapping(value = "/{id}")
	public ResponseEntity<SupplierResponseDTO> updateSupplier(@PathVariable UUID id, @RequestBody SupplierRequestDTO requestDTO){
		return ResponseEntity.ok().body(service.updateSupplier(id, requestDTO));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteSupplier(@PathVariable UUID id) {
		service.deleteSupplier(id);
		return ResponseEntity.noContent().build();
	}

    // todo consultar nos dados de um fornecedor

}
