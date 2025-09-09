package br.com.gunthercloud.distributor.repository;

import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.entity.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long>{

}
