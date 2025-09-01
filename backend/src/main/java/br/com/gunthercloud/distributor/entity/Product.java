package br.com.gunthercloud.distributor.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "tb_product")
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
    private Long barCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;
	
	@Column(nullable = false)
    private Integer stock;
	
	@Column(nullable = false, columnDefinition = "TEXT")
    private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_product_delivery", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns =
	@JoinColumn(name = "delivery_id"))
	private Set<Delivery> delivery = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "supplier_id")
    private Supplier supplier;

}