package br.com.gunthercloud.distributor.repository;

import br.com.gunthercloud.distributor.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findBySupplier(Supplier supplier);

}
