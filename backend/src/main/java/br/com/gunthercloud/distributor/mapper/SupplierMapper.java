package br.com.gunthercloud.distributor.mapper;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.dto.response.SupplierResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

	public SupplierResponseDTO supplierToDTO(Supplier entity) {
		SupplierResponseDTO dto = new SupplierResponseDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public Supplier supplierToEntity(SupplierResponseDTO dto) {
		Supplier entity = new Supplier();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
