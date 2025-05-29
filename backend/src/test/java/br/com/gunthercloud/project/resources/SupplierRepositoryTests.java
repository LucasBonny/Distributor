package br.com.gunthercloud.project.resources;

import br.com.gunthercloud.distributor.entities.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.gunthercloud.distributor.repository.SupplierRepository;

import java.util.Optional;
import java.util.UUID;

@DataJpaTest
public class SupplierRepositoryTests {
	
	@Autowired
	public SupplierRepository repository;

	public UUID existingId;
	public UUID nonExistingId;
	public long countTotalSupplier;

	@BeforeEach
	public void setUp() throws Exception {
		existingId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
		nonExistingId = UUID.fromString("550e8400-e29b-41d4-a716-446655440221");
		countTotalSupplier = 6L;
	}

	@Test
	public void findByIdShouldReturnNotNullWhenIdExists() {

		Optional<Supplier> product = repository.findById(existingId);

		Assertions.assertFalse(product.isEmpty());
	}
}
