package br.com.gunthercloud.distributor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gunthercloud.distributor.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT s FROM Sale s WHERE s.employee.id = :id")
	List<Sale> findByEmployeeId(@Param("id") Long id);

}
