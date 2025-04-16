package br.com.gunthercloud.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.SaleItem;
import br.com.gunthercloud.project.entities.dto.SaleItemDTO;
import br.com.gunthercloud.project.repository.SaleItemRepository;

@Service
public class SaleItemService {
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	public List<SaleItemDTO> findAll(){
		List<SaleItem> emp = saleItemRepository.findAll();
		
		for(SaleItem e : emp) {
			System.out.println("Id product: " + e.getId().getProduct().getBarCode() +
					" Id sale: " + e.getId().getSale().getId() +
		" Price: " + e.getPrice());
		}
		return emp.stream().map(x -> new SaleItemDTO(x)).toList();
	}
	public List<SaleItemDTO> findBySale(Long id) {
		List<SaleItem> list = saleItemRepository.findAll();
		List<SaleItem> emp = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			long subId = list.get(i).getSale().getId();
			if(id == subId) {
				emp.add(list.get(i));
			}
		}
		return emp.stream().map(x -> new SaleItemDTO(x)).toList();
	}
	public List<SaleItem> searchById(Long id) {
		return saleItemRepository.findAll();
	}
}
