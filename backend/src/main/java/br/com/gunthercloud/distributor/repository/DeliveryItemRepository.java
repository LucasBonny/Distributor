package br.com.gunthercloud.distributor.repository;

import br.com.gunthercloud.distributor.entity.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long>{

    List<DeliveryItem> findByDeliveryId(double id);

}
