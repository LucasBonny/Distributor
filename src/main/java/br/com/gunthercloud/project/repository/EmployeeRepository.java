package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
