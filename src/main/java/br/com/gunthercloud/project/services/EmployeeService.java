package br.com.gunthercloud.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.Employee;
import br.com.gunthercloud.project.entities.dto.EmployeeDTO;
import br.com.gunthercloud.project.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeDTO> findAll(){
		List<Employee> emp = employeeRepository.findAll();
		return emp.stream().map(x -> new EmployeeDTO(x)).toList();
	}
	public EmployeeDTO findById(Long id) {
		Employee emp = employeeRepository.findById(id).get();
		return new EmployeeDTO(emp);
	}

}
