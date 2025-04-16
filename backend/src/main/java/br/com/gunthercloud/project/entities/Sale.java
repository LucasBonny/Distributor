package br.com.gunthercloud.project.entities;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import br.com.gunthercloud.project.entities.enums.SaleStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sale")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant saleMoment;
	private SaleStatus saleStatus;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@OneToMany(mappedBy = "sale")
	private List<Payment> payment;
	
	
	public Sale() {
		
	}

	public Sale(Long id, Instant saleMoment, SaleStatus saleStatus) {
		this.id = id;
		this.saleMoment = saleMoment;
		this.saleStatus = saleStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getSaleMoment() {
		return saleMoment;
	}

	public void setSaleMoment(Instant saleMoment) {
		this.saleMoment = saleMoment;
	}

	public SaleStatus getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(SaleStatus saleStatus) {
		this.saleStatus = saleStatus;
	}
	
	public List<Payment> getPayment(){
		return payment;
	}
	
	public Employee getEmployee() {
		return employee;
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
		Sale other = (Sale) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", saleMoment=" + saleMoment + ", saleStatus=" + saleStatus + ", employee=" + employee
				+ ", payment=" + payment + "]";
	}
	
	
}
