package br.com.gunthercloud.distributor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.distributor.entities.dto.SaleItemDTO;
import br.com.gunthercloud.distributor.services.SaleItemService;

@RestController
@RequestMapping(value = "/sales/items")
public class SaleItemResource {
	
	@Autowired
	private SaleItemService saleItemService;
	
	@GetMapping
	public List<SaleItemDTO> findAll(){
		return saleItemService.findAll();
	}
	@GetMapping(value = "/{id}")
	public List<SaleItemDTO> findBySale(@PathVariable Long id) {
		return saleItemService.findBySale(id);
	}

}
