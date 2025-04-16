package br.com.gunthercloud.project.entities.dto;

import java.util.UUID;

import br.com.gunthercloud.project.entities.Supplier;

public class SupplierMinDTO {

	private UUID id;
	private String name;
	private Long cnpj;

	public SupplierMinDTO() {
		
	}

	public SupplierMinDTO(Supplier entity) {
		id = entity.getId();
		cnpj = entity.getCnpj();
		name = entity.getName();
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getCnpj() {
		return cnpj;
	}
	
}
