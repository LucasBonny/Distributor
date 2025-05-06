package br.com.gunthercloud.distributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
