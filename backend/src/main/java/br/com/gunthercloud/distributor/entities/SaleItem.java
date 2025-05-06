package br.com.gunthercloud.distributor.entities;

import java.util.Objects;

import br.com.gunthercloud.distributor.entities.pk.SaleItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sale_item")
public class SaleItem {
	
	@EmbeddedId
	private SaleItemPK id = new SaleItemPK();
	
	private int quantity;
	private double price;
	
	public SaleItem() {
		
	}
	
	public SaleItem(Product product, Sale sale, int quantity, double price) {
		id.setProduct(product);
		id.setSale(sale);
		this.quantity = quantity;
		this.price = price;
	}

	public Product getProduct() {
		return id.getProduct();
	}
	
	public Sale getSale() {
		return id.getSale();
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		SaleItem other = (SaleItem) obj;
		return Objects.equals(id, other.id);
	}

	public SaleItemPK getId() {
		return id;
	}

	@Override
	public String toString() {
		return "SaleItem [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	

}
