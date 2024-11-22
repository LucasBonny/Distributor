package br.com.gunthercloud.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.Sale;
import br.com.gunthercloud.project.entities.dto.SaleMinDTO;
import br.com.gunthercloud.project.repository.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public List<SaleMinDTO> findAll(){
		List<Sale> emp = saleRepository.findAll();
		return emp.stream().map(x -> new SaleMinDTO(x)).toList();
	}
	public Sale findById(Long id) {
		Optional<Sale> emp = saleRepository.findById(id);
		return emp.get();
	}
}
