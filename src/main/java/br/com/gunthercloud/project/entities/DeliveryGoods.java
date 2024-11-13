package br.com.gunthercloud.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import br.com.gunthercloud.project.entities.pk.DeliveryGoodsPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_supplier_product")
public class DeliveryGoods implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private DeliveryGoodsPK id = new DeliveryGoodsPK();
	
	private int quantity;
	private Instant dateDelivery;
	private double price;
	
	public DeliveryGoods() {
		
	}
	public DeliveryGoods(Supplier supplier, Product product, int quantity, Instant dateDelivery, double price) {
		id.setProduct(product);
		id.setSupplier(supplier);
		this.quantity = quantity;
		this.dateDelivery = dateDelivery;
		this.price = price;
	}

	public Supplier getSupplier() {
		return id.getSupplier();
	}
	public void setSupplier(Supplier supplier) {
		id.setSupplier(supplier);
	}
	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
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
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryGoods other = (DeliveryGoods) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
