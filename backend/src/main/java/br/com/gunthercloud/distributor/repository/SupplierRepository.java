package br.com.gunthercloud.distributor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, UUID>{
	
	Supplier findByName(String name);
}
