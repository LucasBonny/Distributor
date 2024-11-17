package br.com.gunthercloud.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.Supplier;
import br.com.gunthercloud.project.entities.dto.SupplierDTO;
import br.com.gunthercloud.project.entities.dto.SupplierMinDTO;
import br.com.gunthercloud.project.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<SupplierMinDTO> findAll(){
		List<Supplier> emp = supplierRepository.findAll();
		return emp.stream().map(x -> new SupplierMinDTO(x)).toList();
	}
	public SupplierDTO findById(Long id) {
		Supplier emp = supplierRepository.findById(id).get();
		return new SupplierDTO(emp);
	}
}
