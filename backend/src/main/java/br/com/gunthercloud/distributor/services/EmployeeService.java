package br.com.gunthercloud.distributor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.distributor.entities.Employee;
import br.com.gunthercloud.distributor.entities.dto.EmployeeDTO;
import br.com.gunthercloud.distributor.entities.enums.EmployeeStatus;
import br.com.gunthercloud.distributor.repository.EmployeeRepository;
import br.com.gunthercloud.distributor.services.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.services.exceptions.NotFoundException;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll() {
		List<Employee> emp = repository.findAll(Sort.by(Sort.Direction.ASC,"name"));
		return emp.stream().map(EmployeeDTO::new).toList();
	}
	
	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) {
		Employee emp = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));
		return new EmployeeDTO(emp);
	}
	
	@Transactional
	public EmployeeDTO create(EmployeeDTO obj) {
		Employee entity = new Employee(obj);
		entity.setId(null);
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		entity.setStatus(EmployeeStatus.ATIVO);
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}
	
	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO obj) {
		Employee entity = new Employee(obj);
		entity.setId(id);
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		try {			
			Employee entity = repository.findById(id).orElseThrow(() -> 
				new NotFoundException("O id " + id + " não existe!"));
			repository.delete(entity);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
//	public void updatePassword(PasswordChange pass) {
//		var user = repository.getReferenceById(1L);
//		if(passwordEncoder.matches(pass.getOldPass(), user.getPassword())) {
//			user.setPassword(passwordEncoder.encode(pass.getNewPass()));
//		}
//	}

}
