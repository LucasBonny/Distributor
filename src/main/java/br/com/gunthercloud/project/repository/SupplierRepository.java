package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
