package br.com.gunthercloud.distributor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private int stock;
	
	@Column(nullable = false, columnDefinition = "TEXT")
    private String imgUrl;

    @OneToMany(mappedBy = "product")
    private Set<DeliveryItem> items = new HashSet<>();

    @Column(nullable = false)
    private boolean active = true;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
    private Supplier supplier;

}