package br.com.gunthercloud.distributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.distributor.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
