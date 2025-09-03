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
	@JoinColumn(name = "delivery_id"), foreignKey = @ForeignKey(name = "fk_entrega_produto", foreignKeyDefinition = "FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE SET NULL"))
	private Set<Delivery> delivery = new HashSet<>();

    @Column(nullable = false)
    private boolean isActive = true;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id != null && id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}