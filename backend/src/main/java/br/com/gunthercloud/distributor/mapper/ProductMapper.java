package br.com.gunthercloud.distributor.mapper;

import br.com.gunthercloud.distributor.dto.request.ProductRequestDTO;
import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.dto.response.ProductResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public ProductResponseDTO productToDTO(Product entity) {
		ProductResponseDTO dto = new ProductResponseDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public Product productToEntity(ProductRequestDTO dto) {
		Product entity = new Product();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
