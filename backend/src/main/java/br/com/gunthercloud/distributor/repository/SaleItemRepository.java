package br.com.gunthercloud.distributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entities.SaleItem;
import br.com.gunthercloud.distributor.entities.pk.SaleItemPK;

public interface SaleItemRepository extends JpaRepository<SaleItem, SaleItemPK>{

}
