package br.com.gunthercloud.distributor.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tb_supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private Long cnpj;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Delivery> deliveries = new HashSet<>();

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        products.add(product);
        product.setSupplier(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setSupplier(null);
    }

    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
        delivery.setSupplier(this);
    }

    public void removeDelivery(Delivery delivery) {
        deliveries.remove(delivery);
        delivery.setSupplier(null);
    }

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
