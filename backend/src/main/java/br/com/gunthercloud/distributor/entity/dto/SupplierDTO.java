package br.com.gunthercloud.distributor.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

	private UUID id;
	private Long cnpj;
	private String name;
	private String address;
	private String cep;
	private String phoneNumber;

}
