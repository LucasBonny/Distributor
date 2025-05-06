package br.com.gunthercloud.distributor.entities;

import java.time.Instant;
import java.util.Objects;

import br.com.gunthercloud.distributor.entities.enums.PaymentMethod;
import br.com.gunthercloud.distributor.entities.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;
	
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;
	
	public Payment() {
		
	}
	public Payment(Long id, Instant moment, PaymentStatus paymentStatus, PaymentMethod paymentMethod) {
		this.id = id;
		this.moment = moment;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMoment() {
		return moment;
	}
	
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
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
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
		
}
