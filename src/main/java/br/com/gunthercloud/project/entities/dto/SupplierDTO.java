package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Supplier;

public class SupplierDTO extends SupplierMinDTO {

	private String address;
	private int cep;
	private Long phoneNumber;
	
	public SupplierDTO() {
		
	}
	
	public SupplierDTO(Supplier entity) {
		super(entity);
		address = entity.getAddress();
		cep = entity.getCep();
		phoneNumber = entity.getPhoneNumber();
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getCep() {
		return cep;
	}
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	
}
