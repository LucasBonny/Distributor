package br.com.gunthercloud.distributor.controller;

import br.com.gunthercloud.distributor.controller.pageable.PageModel;
import br.com.gunthercloud.distributor.controller.pageable.PagedResponse;
import br.com.gunthercloud.distributor.dto.request.ProductRequestDTO;
import br.com.gunthercloud.distributor.dto.response.ProductResponseDTO;
import br.com.gunthercloud.distributor.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.exceptions.NotFoundException;
import br.com.gunthercloud.distributor.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService service;

    @Autowired
    private PagedResponse<ProductResponseDTO> response;

	@GetMapping
	public ResponseEntity<PageModel<ProductResponseDTO>> findAll(@PageableDefault(sort = "name") Pageable pageable) {
        Page<ProductResponseDTO> responseDTO = service.findAll(pageable);
        return ResponseEntity.ok().body(response.request(responseDTO));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(service.findById(id));
        }
        catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }catch (RuntimeException e) {
            throw new RuntimeException("Houve um erro ao executar essa função.");
        }
	}
	
	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(requestDTO));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductResponseDTO> updateProduct(@Valid @PathVariable Long id, @RequestBody ProductRequestDTO requestDTO) {
        try {
            return ResponseEntity.ok().body(service.updateProduct(id, requestDTO));
        }
        catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Há alguns parâmetros no body ausentes.");
        }
        catch (InvalidDataAccessApiUsageException e) {
            throw new InvalidDataAccessApiUsageException("o supplier.id não pode ficar ausente.");
        }
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try{
            service.deleteProduct(id);
            return ResponseEntity.status(204).build();
        } catch (DatabaseException e) {
            throw new DatabaseException("Você não pode remover esse id.");
        }

	}

}
