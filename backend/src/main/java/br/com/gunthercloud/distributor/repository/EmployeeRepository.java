package br.com.gunthercloud.distributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
