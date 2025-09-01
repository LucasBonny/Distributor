package br.com.gunthercloud.distributor.mapper;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.dto.ProductDTO;

public class ProductMapper {
	
	public static ProductDTO toDTO(Product entity) {
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(entity, dto);
        dto.setSupplier(entity.getSupplier().getId());
		return dto;
	}
	
	public static Product toEntity(ProductDTO dto) {
		Product entity = new Product();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
