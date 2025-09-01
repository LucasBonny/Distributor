package br.com.gunthercloud.distributor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.distributor.entity.dto.PaymentDTO;
import br.com.gunthercloud.distributor.service.PaymentService;

@RestController
@RequestMapping(value = "/payments")
@CrossOrigin
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public List<PaymentDTO> findAll(){
		return paymentService.findAll();
	}
	@GetMapping(value = "/{id}")
	public PaymentDTO findById(@PathVariable Long id) {
		return paymentService.findById(id);
	}

}
