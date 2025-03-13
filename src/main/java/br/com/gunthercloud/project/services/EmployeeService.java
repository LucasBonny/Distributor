package br.com.gunthercloud.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.project.entities.Employee;
import br.com.gunthercloud.project.entities.dto.EmployeeDTO;
import br.com.gunthercloud.project.entities.dto.EmployeeMinDTO;
import br.com.gunthercloud.project.entities.enums.EmployeeStatus;
import br.com.gunthercloud.project.repository.EmployeeRepository;
import br.com.gunthercloud.project.services.exceptions.DatabaseException;
import br.com.gunthercloud.project.services.exceptions.NotFoundException;

@Service
public class EmployeeService implements ServiceModel<EmployeeDTO, EmployeeMinDTO, Long>{
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public Page<EmployeeMinDTO> findAllPaged(Pageable pageable) {
		Page<Employee> emp = repository.findAll(pageable);
		return emp.map(EmployeeMinDTO::new);
	}
	
	@Override
	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) {
		Employee emp = repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));
		return new EmployeeDTO(emp);
	}
	
	@Override
	@Transactional
	public EmployeeDTO create(EmployeeDTO obj) {
		Employee entity = new Employee(obj);
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		entity.setStatus(EmployeeStatus.ATIVO);
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}
	
	@Override
	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO obj) {
		Employee entity = new Employee(obj);
		entity.setId(id);
		repository.findById(id).orElseThrow(() -> 
			new NotFoundException("O id " + id + " não existe!"));
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}
	
	@Override
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
