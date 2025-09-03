package br.com.gunthercloud.distributor.mapper;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public ProductDTO productToDTO(Product entity) {
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public Product productToEntity(ProductDTO dto) {
		Product entity = new Product();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
