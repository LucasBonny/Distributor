package br.com.gunthercloud.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.project.entities.dto.ProductDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
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
	
	@Column(nullable = false)
	private String imgUrl;

	@OneToMany(mappedBy = "id")
	private Set<Delivery> delivery = new HashSet<>();	
	
	@OneToMany(mappedBy = "id.product")
	private List<SaleItem> sale = new ArrayList<>();
	
	public Product() {
		
	}

	public Product(Long id, Long barCode, String name, double price, int stock, String imgUrl) {
		this.id = id;
		this.barCode = barCode;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.imgUrl = imgUrl;
	}
	
	public Product(ProductDTO obj) {
		BeanUtils.copyProperties(obj, this);
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

	public List<SaleItem> getSale() {
		return sale;
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
