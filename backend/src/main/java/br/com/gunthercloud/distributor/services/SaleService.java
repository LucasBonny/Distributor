package br.com.gunthercloud.distributor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.distributor.entities.Sale;
import br.com.gunthercloud.distributor.entities.dto.SaleDTO;
import br.com.gunthercloud.distributor.repository.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public List<SaleDTO> findAll(){
		List<Sale> emp = saleRepository.findAll();
		return emp.stream().map(x -> new SaleDTO(x)).toList();
	}
	
	public SaleDTO findById(Long id) {
		return new SaleDTO(saleRepository.findById(id).get());
	}
	
	//Trás todas as vendas abertas pelo funcionário especificado pelo id.
	public List<SaleDTO> findSalesByEmployee(Long id) {
		List<Sale> list = saleRepository.findByEmployeeId(id);
		for (Sale e : list) {
			System.out.println(e);
		}
		return list.stream().map(SaleDTO::new).toList();
	}
}
