package br.com.gunthercloud.distributor.entities.dto;

import java.time.Instant;

import br.com.gunthercloud.distributor.entities.Payment;
import br.com.gunthercloud.distributor.entities.enums.PaymentMethod;
import br.com.gunthercloud.distributor.entities.enums.PaymentStatus;

public class PaymentDTO {
	
	private Long id;
	private Instant moment;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;
	
	public PaymentDTO() {
		
	}
	public PaymentDTO(Payment entity) {
		id = entity.getId();
		moment = entity.getMoment();
		paymentStatus = entity.getPaymentStatus();
		paymentMethod = entity.getPaymentMethod();
	}
	public Long getId() {
		return id;
	}
	public Instant getMoment() {
		return moment;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	
}
