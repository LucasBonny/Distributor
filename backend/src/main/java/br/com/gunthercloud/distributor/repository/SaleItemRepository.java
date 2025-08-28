package br.com.gunthercloud.distributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entity.SaleItem;
import br.com.gunthercloud.distributor.entity.pk.SaleItemPK;

public interface SaleItemRepository extends JpaRepository<SaleItem, SaleItemPK>{

}
