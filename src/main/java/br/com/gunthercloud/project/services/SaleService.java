package br.com.gunthercloud.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<SaleDTO> findSalesByEmployee(Long id, Pageable pageable) {
		Page<Sale> list = saleRepository.findByEmployeeId(id, pageable);
		for (Sale e : list) {
			System.out.println(e);
		}
		return list.map(SaleDTO::new);
	}
}
