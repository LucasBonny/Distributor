package br.com.gunthercloud.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.project.entities.dto.SupplierDTO;
import br.com.gunthercloud.project.services.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierResource {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping
	public List<SupplierDTO> findAll(){
		return supplierService.findAll();
	}
	@GetMapping(value = "/{id}")
	public SupplierDTO findById(@PathVariable Long id) {
		return supplierService.findById(id);
	}

}
