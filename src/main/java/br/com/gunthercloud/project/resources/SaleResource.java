package br.com.gunthercloud.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.project.entities.Sale;
import br.com.gunthercloud.project.services.SaleService;

@RestController
@RequestMapping(value = "/sale")
public class SaleResource {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public List<Sale> findAll(){
		return saleService.findAll();
	}
	@GetMapping(value = "/{id}")
	public Sale findById(@PathVariable Long id) {
		return saleService.findById(id);
	}

}
