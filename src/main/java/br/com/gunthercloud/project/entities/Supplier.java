package br.com.gunthercloud.project.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.project.entities.dto.SupplierDTO;
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
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(unique = true)
	private Long cnpj;
	private String name;
	private String address;
	private int cep;
	private Long phoneNumber;
	
	@OneToMany(mappedBy = "id.supplier")
	private List<DeliveryGoods> product;
	
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

	public Supplier(SupplierDTO obj) {
		BeanUtils.copyProperties(obj, this);
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

	public List<DeliveryGoods> getProduct() {
		return product;
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
