package br.com.gunthercloud.distributor.resources;

import java.util.UUID;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.dto.response.ProductResponseDTO;
import br.com.gunthercloud.distributor.dto.response.SupplierResponseDTO;
import org.springframework.beans.BeanUtils;

public class Factory {

    public static Supplier createSupplier() {
        Supplier sup = new Supplier();
        sup.setId(UUID.fromString("550e8400-e29b-41d4-a716-446655440222"));
        sup.setAddress("St. de Habitações Individuais Sul QL 14 - Lago Sul, Brasília - DF");
        sup.setCep(123681234);
        sup.setCnpj(821734129083L);
        sup.setPhoneNumber(71640321085L);
        sup.setName("Coca-Cola 2");
        return sup;
    }

    public static Product createProduct() {
    	Supplier sup = createSupplier();
    	sup.setId(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"));
        Product nProduct = new Product();

        nProduct.setPrice(12.0);
        nProduct.setStock(1);
        nProduct.setName("Chocolate");
        nProduct.setImgUrl("https://google.com/");
        nProduct.setBarCode(129483712L);
        nProduct.setId(22L);
        nProduct.setSupplier(sup);
        return new Product();
    }

    public static ProductResponseDTO createProductDTO() {
        ProductResponseDTO dto = new ProductResponseDTO();
        BeanUtils.copyProperties(createProduct(), dto);
        return dto;
    }
    
    public static SupplierResponseDTO createSupplierDTO() {
        SupplierResponseDTO dto = new SupplierResponseDTO();
        BeanUtils.copyProperties(createSupplier(), dto);
        return dto;
    }
}
