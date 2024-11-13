package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
