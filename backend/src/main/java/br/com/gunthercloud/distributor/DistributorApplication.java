package br.com.gunthercloud.distributor;

import br.com.gunthercloud.distributor.entity.Delivery;
import br.com.gunthercloud.distributor.entity.DeliveryItem;
import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.repository.DeliveryItemRepository;
import br.com.gunthercloud.distributor.repository.DeliveryRepository;
import br.com.gunthercloud.distributor.repository.ProductRepository;
import br.com.gunthercloud.distributor.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;

@SpringBootApplication
public class DistributorApplication implements CommandLineRunner {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryItemRepository deliveryItemRepository;

    public static void main(String[] args) {
		SpringApplication.run(DistributorApplication.class, args);
	}

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // #1 - cria o fornecedor - TB_SUPPLIER
        Supplier sup = new Supplier(null,11111111111L,"Alameda","Taguatinga","7111111","74612379412", new HashSet<>(), new HashSet<>());
        sup = supplierRepository.save(sup);

        // #2 - cria um produto - TB_PRODUCT
        Product p = new Product(null, 712319345L, "Bala Fini 100g", 1.00, 10,"vazio", new HashSet<>(), true, sup);
        p = productRepository.save(p);

        // #3 - cria a entrega da empresa - TB_DELIVERY
        Delivery d = new Delivery(null, Instant.now(), sup, new HashSet<>());
        d = deliveryRepository.save(d);

        // #4 - cria o produto a ser entregue - TB_DELIVERY_ITEM
        DeliveryItem di1 = new DeliveryItem(null, 10, 10.0, p, d);
        di1 = deliveryItemRepository.save(di1);

        d.addDeliveryItem(di1);
        sup.addDelivery(d);
        sup.addProduct(p);
        p.setSupplier(sup);

        productRepository.save(p);
        supplierRepository.save(sup);
        deliveryRepository.save(d);

        System.out.println("TOTAL: " + d.totalPrice());
    }
}
