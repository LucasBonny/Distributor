package br.com.gunthercloud.distributor.entity.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SupplierDTO {

	private UUID id;
	private Long cnpj;
	private String name;
	private String address;
	private int cep;
	private Long phoneNumber;

}
