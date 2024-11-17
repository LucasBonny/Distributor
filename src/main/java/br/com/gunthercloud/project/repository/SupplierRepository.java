package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	
	//SELECT * FROM TB_SUPPLIER_PRODUCT WHERE TB_SUPPLIER = ID; // Buscar produtos entregues pelo ID da empresa 

}
