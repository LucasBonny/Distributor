package br.com.gunthercloud.distributor.resources;

import java.util.UUID;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.entity.dto.ProductDTO;
import br.com.gunthercloud.distributor.entity.dto.SupplierDTO;
import br.com.gunthercloud.distributor.mapper.ProductMapper;
import br.com.gunthercloud.distributor.mapper.SupplierMapper;

public class Factory {

    public static Supplier createSupplier() {
        return new Supplier(UUID.fromString("550e8400-e29b-41d4-a716-446655440222"), 71640321085L, "Coca-Cola 2", "St. de Habitações Individuais Sul QL 14 - Lago Sul, Brasília - DF",123681234,821734129083L);
    }

    public static Product createProduct() {
    	Supplier sup = createSupplier();
    	sup.setId(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"));
        return new Product(22L, 129483712L, "Chocolate", 12.0, 1, "https://google.com/", sup);
    }

    public static ProductDTO createProductDTO() {
        return ProductMapper.toDTO(createProduct());
    }
    
    public static SupplierDTO createSupplierDTO() {
        return SupplierMapper.toDTO(createSupplier());
    }
}
