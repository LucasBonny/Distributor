package br.com.gunthercloud.distributor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.distributor.entities.dto.SaleDTO;
import br.com.gunthercloud.distributor.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
@CrossOrigin
public class SaleResource {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public List<SaleDTO> findAll(){
		return saleService.findAll();
	}
	@GetMapping(value = "/{id}")
	public SaleDTO findById(@PathVariable Long id) {
		return saleService.findById(id);
	}

}
