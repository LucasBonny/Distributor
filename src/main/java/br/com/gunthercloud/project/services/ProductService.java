package br.com.gunthercloud.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.DeliveryGoods;
import br.com.gunthercloud.project.entities.Product;
import br.com.gunthercloud.project.entities.dto.ProductDTO;
import br.com.gunthercloud.project.entities.dto.ProductDeliveryDTO;
import br.com.gunthercloud.project.entities.dto.ProductSearchDTO;
import br.com.gunthercloud.project.repository.DeliveryGoodsRepository;
import br.com.gunthercloud.project.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private DeliveryGoodsRepository deliveryGoodsRepository;
	
	public List<ProductDTO> findAll(){
		List<Product> list =  productRepository.findAll();
		return list.stream().map(x -> new ProductDTO(x)).toList();
	}
	public ProductDTO findById(Long id) {
		Product emp = productRepository.findById(id).get();
		return new ProductDTO(emp);
	}
	//Busca todos os produtos da empresa 
	public List<ProductSearchDTO> searchAll(Long id){
		List<DeliveryGoods> search = deliveryGoodsRepository.findAll();
		List<Product> list = new ArrayList<>();
		for(DeliveryGoods e : search) {
			if(e.getSupplier().getId() == id) {
				list.add(e.getProduct());
			}
		}
 		return list.stream().map(x -> new ProductSearchDTO(x)).toList();
	}
	
	//Buscar todas as entregas da empresa específicada - OK
	public List<ProductDeliveryDTO> deliveryAll(Long id){
		
		List<DeliveryGoods> list = deliveryGoodsRepository.findAll();
		List<DeliveryGoods> supplier = new ArrayList<>();
		
		for(DeliveryGoods e : list) {
			if(id == e.getSupplier().getId()) {
				supplier.add(e);
			}
		}
 		return supplier.stream().map(x -> new ProductDeliveryDTO(x)).toList();
	}
	
}
