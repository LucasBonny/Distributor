package br.com.gunthercloud.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.project.entities.DeliveryGoods;
import br.com.gunthercloud.project.entities.pk.DeliveryGoodsPK;
import br.com.gunthercloud.project.repository.DeliveryGoodsRepository;

@Service
public class DeliveryGoodsService {
	
	@Autowired
	private DeliveryGoodsRepository deliveryGoodsRepository;
	
	public List<DeliveryGoods> findAll(){
		List<DeliveryGoods> emp = deliveryGoodsRepository.findAll();
		return emp;
	}
	public DeliveryGoods findById(DeliveryGoodsPK id) {
		DeliveryGoods emp = deliveryGoodsRepository.findById(id).get();
		return emp;
	}
}
