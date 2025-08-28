package br.com.gunthercloud.distributor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.gunthercloud.distributor.entity.dto.EmployeeDTO;
import br.com.gunthercloud.distributor.entity.dto.SaleDTO;
import br.com.gunthercloud.distributor.entity.enums.EmployeeStatus;
import br.com.gunthercloud.distributor.service.EmployeeService;
import br.com.gunthercloud.distributor.service.SaleService;

@RestController
@RequestMapping(value = "/employees")
@CrossOrigin
public class EmployeeResource {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	@GetMapping(value = "/status")
	public ResponseEntity<List<EmployeeStatus>> findAllStatus() {
		return ResponseEntity.ok(EmployeeStatus.findAll());
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO obj) {
		return ResponseEntity.status(201).body(service.create(obj));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody EmployeeDTO obj) {
		return ResponseEntity.ok().body(service.update(id, obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}
	
	@GetMapping(value = "/{id}/sales")
	public List<SaleDTO> findSalesByEmployee(@PathVariable Long id) {
		return saleService.findSalesByEmployee(id);
	}
}
