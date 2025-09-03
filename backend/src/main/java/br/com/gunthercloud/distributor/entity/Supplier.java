package br.com.gunthercloud.distributor.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tb_supplier")
@Data
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(unique = true, nullable = false)
	private Long cnpj;

	@Column(unique = true,nullable = false)
	private String name;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private int cep;

	@Column(nullable = false)
	private Long phoneNumber;
	
	@OneToMany(mappedBy = "supplier")
	private Set<Delivery> deliveries = new HashSet<>();

	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> products = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id != null && id.equals(supplier.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
