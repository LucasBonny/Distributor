package br.com.gunthercloud.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.SaleItem;
import br.com.gunthercloud.project.entities.pk.SaleItemPK;
import br.com.gunthercloud.project.repository.SaleItemRepository;

@Service
public class SaleItemService {
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	public List<SaleItem> findAll(){
		List<SaleItem> emp = saleItemRepository.findAll();
		return emp;
	}
	public SaleItem findById(SaleItemPK id) {
		Optional<SaleItem> emp = saleItemRepository.findById(id);
		return emp.get();
	}
	public List<SaleItem> searchById(Long id) {
		return saleItemRepository.findAll();
	}
}
