package br.com.gunthercloud.project.entities;

import java.time.Instant;

import br.com.gunthercloud.project.entities.enums.PaymentMethod;
import br.com.gunthercloud.project.entities.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;
	
}
