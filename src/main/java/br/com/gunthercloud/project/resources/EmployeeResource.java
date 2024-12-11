package br.com.gunthercloud.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.project.entities.dto.EmployeeDTO;
import br.com.gunthercloud.project.entities.dto.EmployeeMinDTO;
import br.com.gunthercloud.project.entities.dto.SaleDTO;
import br.com.gunthercloud.project.services.EmployeeService;
import br.com.gunthercloud.project.services.SaleService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public List<EmployeeMinDTO> findAll(){
		return employeeService.findAll();
	}
	@GetMapping(value = "/{id}")
	public EmployeeDTO findById(@PathVariable Long id) {
		return employeeService.findById(id);
	}
	@GetMapping(value = "/{id}/sale")
	public SaleDTO findByEmployee(@PathVariable Long id) {
		return saleService.findById(id);
	}

}
