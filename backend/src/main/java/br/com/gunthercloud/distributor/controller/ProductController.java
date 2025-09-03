package br.com.gunthercloud.distributor.controller;

import java.util.List;

import br.com.gunthercloud.distributor.controller.model.PageModel;
import br.com.gunthercloud.distributor.controller.model.PageableModel;
import br.com.gunthercloud.distributor.controller.model.PagedResponse;
import br.com.gunthercloud.distributor.service.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.service.exceptions.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import br.com.gunthercloud.distributor.entity.dto.ProductDTO;
import br.com.gunthercloud.distributor.service.ProductService;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService service;

    @Autowired
    private PagedResponse<ProductDTO> response;

	@GetMapping
	public ResponseEntity<PageModel<ProductDTO>> findAll(@PageableDefault(sort = "name") Pageable pageable) {
        Page<ProductDTO> paged = service.findAll(pageable);
        return ResponseEntity.ok().body(response.request(paged));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
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
	public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(obj));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@Valid @PathVariable Long id, @RequestBody ProductDTO obj) {
        try {
            return ResponseEntity.ok().body(service.updateProduct(id, obj));
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
