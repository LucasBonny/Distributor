package br.com.gunthercloud.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.project.entities.DeliveryGoods;
import br.com.gunthercloud.project.entities.pk.DeliveryGoodsPK;
import br.com.gunthercloud.project.services.DeliveryGoodsService;

@RestController
@RequestMapping(value = "/delivery")
@CrossOrigin
public class DeliveryGoodsResource {
	
	@Autowired
	private DeliveryGoodsService deliveryGoodsService;
	
	@GetMapping
	public List<DeliveryGoods> findAll(){
		return deliveryGoodsService.findAll();
	}
	@GetMapping(value = "/{id}")
	public DeliveryGoods findById(@PathVariable DeliveryGoodsPK id) {
		return deliveryGoodsService.findById(id);
	}

}
