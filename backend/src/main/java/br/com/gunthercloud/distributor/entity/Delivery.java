package br.com.gunthercloud.distributor.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.dto.DeliveryDTO;

@Data
@Entity
@Table(name = "tb_delivery")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dateTimeDelivery;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

	@ManyToMany(mappedBy = "delivery")
	private List<Product> products;
	
}
