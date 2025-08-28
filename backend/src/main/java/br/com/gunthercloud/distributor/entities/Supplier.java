package br.com.gunthercloud.distributor.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_supplier")
public class Supplier implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(unique = true, nullable = false)
	private Long cnpj;
	@Column(unique = true,nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private int cep;
	@Column(nullable = false)
	private Long phoneNumber;
	
	@OneToMany(mappedBy = "supplier")
	private Set<Delivery> deliveries = new HashSet<>();

	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<>();
	
	public Supplier(){
		
	}

	public Supplier(UUID id, Long cnpj, String name, String address, int cep, Long phoneNumber) {
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.address = address;
		this.cep = cep;
		this.phoneNumber = phoneNumber;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Delivery> getDelivery() {
		return deliveries;
	}
	public Set<Product> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", cnpj=" + cnpj + ", name=" + name + ", address=" + address + ", cep=" + cep
				+ ", phoneNumber=" + phoneNumber + ", deliveries=" + deliveries + ", products=" + products + "]";
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
		Supplier other = (Supplier) obj;
		return Objects.equals(id, other.id);
	}

}
