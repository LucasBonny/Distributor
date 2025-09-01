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
    @NotNull(message = "O código de barras é obrigatório.")
    private Long barCode;

    @Column(nullable = false)
    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Size(min = 8, max = 50, message = "O nome do produto deve ter entre 8 e 50 caracteres.")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "O preço do produto não pode ser nulo.")
    @Positive(message = "O preço do produto deve ser um valor positivo.")
    private Double price;
	
	@Column(nullable = false)
    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @Positive(message = "A quantidade em estoque tem que ser maior que 0.")
    private Integer stock;
	
	@Column(nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "A URL da imagem é obrigatória.")
    private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_product_delivery", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns =
	@JoinColumn(name = "delivery_id"))
	private Set<Delivery> delivery = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "supplier_id")
    @NotNull(message = "O ID do fornecedor é obrigatório.")
    private Supplier supplier;

}