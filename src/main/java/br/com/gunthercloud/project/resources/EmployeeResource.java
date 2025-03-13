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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.project.entities.dto.EmployeeDTO;
import br.com.gunthercloud.project.entities.dto.EmployeeMinDTO;
import br.com.gunthercloud.project.entities.dto.SaleDTO;
import br.com.gunthercloud.project.services.EmployeeService;
import br.com.gunthercloud.project.services.SaleService;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin
public class EmployeeResource implements ResourceModel<EmployeeDTO, EmployeeMinDTO, Long> {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	@Override
	public ResponseEntity<Page<EmployeeMinDTO>> findAllPaged(@PageableDefault(page = 0,size = 10, sort = "name") Pageable pageable) {
		return ResponseEntity.ok().body(service.findAllPaged(pageable));
	}
	
	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@Override
	@PostMapping
	public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO obj) {
		return ResponseEntity.status(201).body(service.create(obj));
	}
	
	@Override
	@PutMapping
	public ResponseEntity<EmployeeDTO> update(Long id, EmployeeDTO obj) {
		return ResponseEntity.ok().body(service.update(id, obj));
	}
	
	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}
	
	@GetMapping(value = "/{id}/sale")
	public Page<SaleDTO> findSalesByEmployee(@PathVariable Long id, @PageableDefault(page = 0,size = 10) Pageable pageable) {
		return saleService.findSalesByEmployee(id, pageable);
	}
}
