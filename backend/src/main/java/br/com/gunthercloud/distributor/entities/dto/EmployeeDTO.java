package br.com.gunthercloud.distributor.entities.dto;

import java.time.format.DateTimeFormatter;

import br.com.gunthercloud.distributor.entities.Employee;
import br.com.gunthercloud.distributor.entities.enums.EmployeeStatus;

public class EmployeeDTO {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Long cpf;
	private String birthDate;
	private Long phoneNumber;
	private EmployeeStatus status;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Employee entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.cpf = entity.getCpf();
        DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.birthDate = entity.getBirthDate().format(fm1);
        this.phoneNumber = entity.getPhoneNumber();
        this.status = entity.getStatus();
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

	public String getPassword() {
		return password;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

}
