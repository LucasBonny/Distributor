package br.com.gunthercloud.distributor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponseSimpleDTO {

	private UUID id;
	private Long cnpj;
	private String name;
	private String address;
	private String cep;
	private String phoneNumber;

}
