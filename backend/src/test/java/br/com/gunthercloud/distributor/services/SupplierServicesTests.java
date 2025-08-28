package br.com.gunthercloud.distributor.services;

import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.entity.dto.SupplierDTO;
import br.com.gunthercloud.distributor.repository.SupplierRepository;
import br.com.gunthercloud.distributor.resources.Factory;
import br.com.gunthercloud.distributor.service.SupplierService;
import br.com.gunthercloud.distributor.service.exceptions.NotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class SupplierServicesTests {
    @InjectMocks
    private SupplierService service;

    @Mock
    private SupplierRepository repository;

    private UUID existingId;
    private UUID nonExistingId;
    private Supplier supplier;
    private List<Supplier> page;

    @BeforeEach
    void setUp() throws Exception{
        existingId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        nonExistingId = UUID.fromString("550e8400-e29b-41d4-a716-446655440221");
        supplier = Factory.createSupplier();
        page = List.of(supplier);

        when(repository.findAll()).thenReturn(page);

        when(repository.findById(existingId)).thenReturn(Optional.of(supplier));
        when(repository.getReferenceById(nonExistingId)).thenThrow(NotFoundException.class);

        when(repository.getReferenceById(existingId)).thenReturn(supplier);

        when(repository.save(ArgumentMatchers.any())).thenReturn(supplier);
        when(repository.findAll(Sort.by(Sort.Direction.ASC,"name"))).thenReturn(page);


        when(repository.existsById(existingId)).thenReturn(true);
        doNothing().when(repository).deleteById(existingId);
        when(repository.existsById(nonExistingId)).thenThrow(NotFoundException.class);
    }

    @Test
    public void updateShouldThrowNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            service.update(nonExistingId, Factory.createSupplierDTO());
        });
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {


        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });

        verify(repository, Mockito.times(1)).deleteById(existingId);

    }

    @Test
    public void findAllShouldReturnList() {
        List<SupplierDTO> supplier = service.findAll();

        verify(repository, times(1)).findAll(Sort.by(Sort.Direction.ASC,"name"));
        Assertions.assertNotNull(supplier);
        Assertions.assertFalse(supplier.isEmpty());
        Assertions.assertEquals(1, supplier.size());
    }

    @Test
    public void findByIdShouldReturnObjectWhenIdExists() {

        SupplierDTO result = service.findById(existingId);
        verify(repository).findById(existingId);
        Assertions.assertEquals(supplier.getName(), result.getName());

    }

    @Test
    public void findByIdShouldThrowNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            service.findById(nonExistingId);
        });
    }

}
