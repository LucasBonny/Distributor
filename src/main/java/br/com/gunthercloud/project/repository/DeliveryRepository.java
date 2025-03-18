package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

	// Filtro de produto para localizar o fornecedor
	//Optional<DeliveryGoods> findByIdProductId(Long productId);
	
}
