package br.com.gunthercloud.distributor.entities.dto;

import java.util.UUID;

import br.com.gunthercloud.distributor.entities.Supplier;

public class SupplierDTO {

	private UUID id;
	private Long cnpj;
	private String name;
	private String address;
	private int cep;
	private Long phoneNumber;
	
	public SupplierDTO() {
		super();
	}
	
	public SupplierDTO(Supplier entity) {
        this.id = entity.getId();
        this.cnpj = entity.getCnpj();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.cep = entity.getCep();
        this.phoneNumber = entity.getPhoneNumber();
    }
	
	public UUID getId() {
		return id;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public String getName() {
		return name;
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
