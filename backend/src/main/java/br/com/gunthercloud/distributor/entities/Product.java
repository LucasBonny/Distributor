package br.com.gunthercloud.distributor.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private Long barCode;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private int stock;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_product_delivery", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns =
	@JoinColumn(name = "delivery_id"))
	private Set<Delivery> delivery = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

	public Product() {
		
	}

	public Product(Long id, Long barCode, String name, double price, int stock, String imgUrl, Supplier supplier) {
		this.id = id;
		this.barCode = barCode;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.imgUrl = imgUrl;
		this.supplier = supplier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBarCode() {
		return barCode;
	}

	public void setBarCode(Long barCode) {
		this.barCode = barCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void increaseStock(int stock) {
		this.stock += stock;
	}
	public void decreaseStock(int stock) {
		this.stock -= stock;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Delivery> getDelivery() {
		return delivery;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", barCode=" + barCode + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", imgUrl=" + imgUrl + ", delivery=" + delivery + ", supplier=" + supplier + "]";
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
