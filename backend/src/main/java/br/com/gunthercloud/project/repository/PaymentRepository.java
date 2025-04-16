package br.com.gunthercloud.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.project.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
