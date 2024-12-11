package br.com.gunthercloud.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.Sale;
import br.com.gunthercloud.project.entities.dto.SaleDTO;
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
	public SaleDTO findById(Long id) {
		return new SaleDTO(saleRepository.findById(id).get());
	}
	//Trás todas as vendas abertas pelo funcionário especificado pelo id.
	public List<SaleDTO> findByEmployee(Long id) {
		List<Sale> list = saleRepository.findAll();
		for (Sale e : list) {
			System.out.println(e);
		}
		return list.stream().map(x -> new SaleDTO(x)).toList();
	}
}
