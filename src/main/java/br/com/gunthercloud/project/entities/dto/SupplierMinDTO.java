package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Supplier;

public class SupplierMinDTO {

	private Long id;
	private String name;
	private Long cnpj;

	public SupplierMinDTO() {
		
	}

	public SupplierMinDTO(Supplier entity) {
		id = entity.getId();
		name = entity.getName();
		cnpj = entity.getCnpj();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getCnpj() {
		return cnpj;
	}
	
	
	
	
}
