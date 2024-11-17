package br.com.gunthercloud.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long barCode;
	private String name;
	private double price;
	private int stock;
	private String imgUrl;

	@OneToMany(mappedBy = "id.product")
	private List<DeliveryGoods> supplier = new ArrayList<>();	
	
	@OneToMany(mappedBy = "id.product")
	private List<SaleItem> sale = new ArrayList<>();
	
	public Product() {
		
	}

	public Product(Long barCode, String name, double price, int stock, String imgUrl) {
		this.barCode = barCode;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.imgUrl = imgUrl;
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

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public List<SaleItem> getProduct() {
		return sale;
	}
	public List<DeliveryGoods> getDeliveryGoods() {
		return supplier;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barCode);
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
		return Objects.equals(barCode, other.barCode);
	}
	
}
