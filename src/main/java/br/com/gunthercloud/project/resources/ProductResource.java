package br.com.gunthercloud.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.project.entities.Product;
import br.com.gunthercloud.project.entities.dto.ProductDTO;
import br.com.gunthercloud.project.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> findAll(){
		List<Product> list = productService.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		return productService.findById(id);
	}
}
