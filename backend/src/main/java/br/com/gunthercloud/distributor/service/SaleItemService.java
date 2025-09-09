package br.com.gunthercloud.distributor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.distributor.entity.SaleItem;
import br.com.gunthercloud.distributor.dto.response.SaleItemDTO;
import br.com.gunthercloud.distributor.repository.SaleItemRepository;

@Service
public class SaleItemService {
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	@Transactional(readOnly = true)
	public List<SaleItemDTO> findAll(){
		List<SaleItem> emp = saleItemRepository.findAll();
		
		for(SaleItem e : emp) {
			System.out.println("Id product: " + e.getId().getProduct().getBarCode() +
					" Id sale: " + e.getId().getSale().getId() +
		" Price: " + e.getPrice());
		}
		return emp.stream().map(x -> new SaleItemDTO(x)).toList();
	}

	@Transactional(readOnly = true)
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

	@Transactional(readOnly = true)
	public List<SaleItem> searchById(Long id) {
		return saleItemRepository.findAll();
	}
}
