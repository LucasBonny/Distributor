package br.com.gunthercloud.distributor.mapper;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.entity.dto.ProductDTO;
import br.com.gunthercloud.distributor.entity.dto.SupplierDTO;
import br.com.gunthercloud.distributor.entity.dto.SupplierWithProductsDTO;

public class SupplierMapper {

	public static SupplierDTO toDTO(Supplier entity) {
		SupplierDTO dto = new SupplierDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static Supplier toEntity(SupplierDTO dto) {
		Supplier entity = new Supplier();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public static SupplierWithProductsDTO toDTOWithProducts(Supplier entity) {
		SupplierWithProductsDTO dto = new SupplierWithProductsDTO();
		BeanUtils.copyProperties(entity, dto);
		for(Product p : entity.getProducts()) {
			System.out.println(p.getName());
			dto.getProducts().add(ProductMapper.toDTO(p));			
		}
		return dto;
	}
	public static Supplier toEntityWithProducts(SupplierWithProductsDTO dto) {
		Supplier entity = new Supplier();
		BeanUtils.copyProperties(dto, entity);
		for(ProductDTO p : dto.getProducts())
			entity.getProducts().add(ProductMapper.toEntity(p));
		return entity;
	}

}
