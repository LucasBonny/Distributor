package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
