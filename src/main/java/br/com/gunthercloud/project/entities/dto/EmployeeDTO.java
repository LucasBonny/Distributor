package br.com.gunthercloud.project.entities.dto;

import java.time.LocalDate;

import br.com.gunthercloud.project.entities.Employee;
import br.com.gunthercloud.project.entities.enums.EmployeeStatus;

public class EmployeeDTO extends EmployeeMinDTO {
	
	private String password;
	private Long cpf;
	private LocalDate birthDate;
	private EmployeeStatus status;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Employee entity) {
		super(entity);
		password = entity.getPassword();
		cpf = entity.getCpf();
		birthDate = entity.getBirthDate();
		status = entity.getStatus();
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

	public EmployeeStatus getStatus() {
		return status;
	}

}
