package br.com.gunthercloud.distributor.mapper;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.entity.dto.ProductDTO;
import br.com.gunthercloud.distributor.entity.dto.SupplierDTO;
import br.com.gunthercloud.distributor.entity.dto.SupplierWithProductsDTO;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

	public SupplierDTO supplierToDTO(Supplier entity) {
		SupplierDTO dto = new SupplierDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public Supplier supplierToEntity(SupplierDTO dto) {
		Supplier entity = new Supplier();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
