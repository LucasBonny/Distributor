package br.com.gunthercloud.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.Sale;
import br.com.gunthercloud.project.repository.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findAll(){
		List<Sale> emp = saleRepository.findAll();
		return emp;
	}
	public Sale findById(Long id) {
		Optional<Sale> emp = saleRepository.findById(id);
		return emp.get();
	}
	public List<Sale> searchById(Long id) {
		return saleRepository.findAll();
	}
}
