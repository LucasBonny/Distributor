package br.com.gunthercloud.distributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
