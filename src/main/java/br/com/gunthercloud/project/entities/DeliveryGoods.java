package br.com.gunthercloud.project.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_supplier_product")
public class DeliveryGoods implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int quantity;
	private Instant dateDelivery;
	private double price;
	
	public DeliveryGoods() {
		
	}
	public DeliveryGoods(int quantity, Instant dateDelivery, double price) {
		this.quantity = quantity;
		this.dateDelivery = dateDelivery;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Instant getDateDelivery() {
		return dateDelivery;
	}
	public void setDateDelivery(Instant dateDelivery) {
		this.dateDelivery = dateDelivery;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
