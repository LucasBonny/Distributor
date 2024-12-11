package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Supplier;

public class SupplierMinDTO {

	private String name;
	private Long cnpj;

	public SupplierMinDTO() {
		
	}

	public SupplierMinDTO(Supplier entity) {
		cnpj = entity.getCnpj();
		name = entity.getName();
	}

	public String getName() {
		return name;
	}

	public Long getCnpj() {
		return cnpj;
	}
	
	
	
	
}
