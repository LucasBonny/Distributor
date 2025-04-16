package br.com.gunthercloud.project.entities.dto;

import java.time.Instant;

import br.com.gunthercloud.project.entities.Sale;
import br.com.gunthercloud.project.entities.enums.SaleStatus;

public class SaleMinDTO {
	
	private Long id;
	private Instant saleMoment;
	private SaleStatus saleStatus;
	
	public SaleMinDTO(Sale entity) {
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
