package br.com.gunthercloud.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import br.com.gunthercloud.project.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT s FROM Sale s WHERE s.employee.id = :id")
	Page<Sale> findByEmployeeId(@Param("id") Long id, @PageableDefault(page = 0,size = 10) Pageable pageable);

}
