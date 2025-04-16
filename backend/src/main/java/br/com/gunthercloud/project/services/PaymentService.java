package br.com.gunthercloud.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.Payment;
import br.com.gunthercloud.project.entities.dto.PaymentDTO;
import br.com.gunthercloud.project.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<PaymentDTO> findAll(){
		List<Payment> emp = paymentRepository.findAll();
		return emp.stream().map(x -> new PaymentDTO(x)).toList();
	}
	public PaymentDTO findById(Long id) {
		Payment emp = paymentRepository.findById(id).get();
		return new PaymentDTO(emp);
	}
	public List<Payment> searchById(Long id) {
		return paymentRepository.findAll();
	}
}
