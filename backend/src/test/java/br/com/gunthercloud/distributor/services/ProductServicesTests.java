package br.com.gunthercloud.distributor.services;

import br.com.gunthercloud.distributor.entity.Product;
import br.com.gunthercloud.distributor.dto.response.ProductResponseDTO;
import br.com.gunthercloud.distributor.repository.ProductRepository;
import br.com.gunthercloud.distributor.resources.Factory;
import br.com.gunthercloud.distributor.service.ProductService;
import br.com.gunthercloud.distributor.exceptions.NotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ProductServicesTests {
    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private long existingId;
    private long nonExistingId;
    private Product product;
    private List<Product> page;

    @BeforeEach
    void setUp() throws Exception{
        existingId = 1L;
        nonExistingId = 200L;
        product = Factory.createProduct();
        page = List.of(product);

        when(repository.findAll()).thenReturn(page);

        when(repository.findById(existingId)).thenReturn(Optional.of(product));
        when(repository.getReferenceById(nonExistingId)).thenThrow(NotFoundException.class);

        when(repository.getReferenceById(existingId)).thenReturn(product);

        when(repository.save(ArgumentMatchers.any())).thenReturn(product);
        when(repository.findAll(Sort.by(Sort.Direction.ASC,"name"))).thenReturn(page);


        when(repository.existsById(existingId)).thenReturn(true);
        doNothing().when(repository).deleteById(existingId);
        when(repository.existsById(nonExistingId)).thenThrow(NotFoundException.class);
    }

    @Test
    public void updateShouldThrowNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            service.updateProduct(nonExistingId, Factory.createProductDTO());
        });
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {


        Assertions.assertDoesNotThrow(() -> {
            service.deleteProduct(existingId);
        });

        verify(repository, Mockito.times(1)).deleteById(existingId);

    }

    @Test
    public void findAllShouldReturnList() {
        Page<ProductResponseDTO> product = service.findAll(PageRequest.of(0,10));

        verify(repository, times(1)).findAll(Sort.by(Sort.Direction.ASC,"name"));
        Assertions.assertNotNull(product);
        Assertions.assertFalse(product.isEmpty());
        Assertions.assertEquals(1, product.getSize());
    }

    @Test
    public void findByIdShouldReturnObjectWhenIdExists() {

        ProductResponseDTO result = service.findById(existingId);
        verify(repository).findById(existingId);
        Assertions.assertEquals(product.getName(), result.getName());

    }

    @Test
    public void findByIdShouldThrowNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            service.findById(nonExistingId);
        });
    }

}
