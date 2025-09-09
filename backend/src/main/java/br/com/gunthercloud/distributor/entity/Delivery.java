package br.com.gunthercloud.distributor.entity;

import java.time.Instant;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_delivery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private Instant dateTimeDelivery;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

    @OneToMany(mappedBy = "delivery")
    private Set<DeliveryItem> items = new HashSet<>();

    public void addDeliveryItem(DeliveryItem item) {
        item.setDelivery(this);
        items.add(item);
    }

    public void removeDeliveryItem(DeliveryItem item) {
        item.setDelivery(null);
        items.remove(item);
    }

    public double totalPrice() {
        double total = 0.0;
        for (DeliveryItem di : items) total += di.calculateTotal();
        return total;
    }
	
}
