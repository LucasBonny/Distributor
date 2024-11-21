package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.SaleItem;
import br.com.gunthercloud.project.entities.pk.SaleItemPK;

public interface SaleItemRepository extends JpaRepository<SaleItem, SaleItemPK>{

}
