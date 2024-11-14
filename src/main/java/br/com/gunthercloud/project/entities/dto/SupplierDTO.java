package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Supplier;

public class SupplierDTO {
	
	private Long id;
	private String name;
	private Long cnpj;
	private String address;
	private int cep;
	private Long phoneNumber;
	
	public SupplierDTO() {
		
	}
	public SupplierDTO(Supplier entity) {
		id = entity.getId();
		name = entity.getName();
		cnpj = entity.getCnpj();
		address = entity.getAddress();
		cep = entity.getCep();
		phoneNumber = entity.getPhoneNumber();
	}
	public Long getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public String getName() {
		return name;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public int getCep() {
		return cep;
	}

	
}
