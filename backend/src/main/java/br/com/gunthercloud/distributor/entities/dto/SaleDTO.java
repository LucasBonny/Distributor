package br.com.gunthercloud.distributor.entities.dto;

import java.time.Instant;

import br.com.gunthercloud.distributor.entities.Sale;
import br.com.gunthercloud.distributor.entities.enums.SaleStatus;

public class SaleDTO {
	
	private Long id;
	private Instant saleMoment;
	private SaleStatus saleStatus;
	
	public SaleDTO(Sale entity) {
		id = entity.getId();
		saleMoment = entity.getSaleMoment();
		saleStatus = entity.getSaleStatus();
	}

	public Long getId() {
		return id;
	}

	public Instant getSaleMoment() {
		return saleMoment;
	}

	public SaleStatus getSaleStatus() {
		return saleStatus;
	}
	
}
