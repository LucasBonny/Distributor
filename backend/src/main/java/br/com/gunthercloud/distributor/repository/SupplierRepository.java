package br.com.gunthercloud.distributor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, UUID>{
	
	//SELECT * FROM TB_SUPPLIER_PRODUCT WHERE TB_SUPPLIER = ID; // Buscar produtos entregues pelo ID da empresa 

}
