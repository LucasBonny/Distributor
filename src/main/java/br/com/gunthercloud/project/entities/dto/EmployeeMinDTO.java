package br.com.gunthercloud.project.entities.dto;

import br.com.gunthercloud.project.entities.Employee;

public class EmployeeMinDTO {
	
	private Long id;
	private String name;
	private String email;
	private Long phoneNumber;
	
	public EmployeeMinDTO() {
		
	}

	public EmployeeMinDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}
	

}
