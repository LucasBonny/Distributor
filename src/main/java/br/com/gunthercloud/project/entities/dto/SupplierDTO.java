package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Supplier;

public class SupplierDTO {
	
	private Long cnpj;
	private String name;
	private String address;
	private int cep;
	private Long phoneNumber;
	
	public SupplierDTO() {
		
	}
	public SupplierDTO(Supplier entity) {
		cnpj = entity.getCnpj();
		name = entity.getName();
		address = entity.getAddress();
		cep = entity.getCep();
		phoneNumber = entity.getPhoneNumber();
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
