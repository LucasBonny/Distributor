package br.com.gunthercloud.distributor.mapper;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entities.Product;
import br.com.gunthercloud.distributor.entities.dto.ProductDTO;

public class ProductMapper {
	
	public static ProductDTO toDTO(Product entity) {
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static Product toEntity(ProductDTO dto) {
		Product entity = new Product();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
