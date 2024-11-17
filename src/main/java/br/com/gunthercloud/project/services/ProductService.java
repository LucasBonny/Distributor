package br.com.gunthercloud.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.Product;
import br.com.gunthercloud.project.entities.dto.ProductDTO;
import br.com.gunthercloud.project.entities.dto.ProductSearchDTO;
import br.com.gunthercloud.project.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	public ProductDTO findById(Long id) {
		Product emp = productRepository.findById(id).get();
		return new ProductDTO(emp);
	}
	public List<ProductSearchDTO> searchAll(Long id){
		List<Product> list = productRepository.findAll();
 		return list.stream().map(x -> new ProductSearchDTO(x)).toList();
	}
	
}
