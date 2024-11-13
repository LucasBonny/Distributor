package br.com.gunthercloud.project.entities.dto;

import java.time.LocalDate;

import br.com.gunthercloud.project.entities.Employee;

public class EmployeeDTO {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Long cpf;
	private LocalDate birthDate;
	private Long phoneNumber;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		password = entity.getPassword();
		cpf = entity.getCpf();
		birthDate = entity.getBirthDate();
		phoneNumber = entity.getPhoneNumber();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Long getCpf() {
		return cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}
	

}
