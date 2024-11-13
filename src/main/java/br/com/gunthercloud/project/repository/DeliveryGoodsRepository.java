package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.DeliveryGoods;
import br.com.gunthercloud.project.entities.pk.DeliveryGoodsPK;

public interface DeliveryGoodsRepository extends JpaRepository<DeliveryGoods, DeliveryGoodsPK>{

}
