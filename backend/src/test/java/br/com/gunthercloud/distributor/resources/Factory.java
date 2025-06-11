package br.com.gunthercloud.distributor.resources;

import br.com.gunthercloud.distributor.entities.Product;
import br.com.gunthercloud.distributor.entities.Supplier;
import br.com.gunthercloud.distributor.entities.dto.ProductDTO;
import br.com.gunthercloud.distributor.entities.dto.SupplierDTO;

import java.util.UUID;

public class Factory {

    public static Supplier createSupplier() {
        return new Supplier(UUID.fromString("550e8400-e29b-41d4-a716-446655440222"), 71640321085L, "Coca-Cola 2", "St. de Habitações Individuais Sul QL 14 - Lago Sul, Brasília - DF",123681234,821734129083L);
    }

    public static SupplierDTO createSupplierDTO() {
        return new SupplierDTO(createSupplier());
    }

    public static Product createProduct() {
        return new Product(22L, 129483712L, "Chocolate", 12.0, 1, "https://google.com/", createSupplier());
    }

    public static ProductDTO createProductDTO() {
        return new ProductDTO(createProduct());
    }
}
