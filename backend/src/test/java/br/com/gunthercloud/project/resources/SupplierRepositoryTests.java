package br.com.gunthercloud.project.resources;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.gunthercloud.project.repository.SupplierRepository;

@DataJpaTest
public class SupplierRepositoryTest {
	
	@Autowired
	public SupplierRepository repository;
	
	@BeforeEach
	private void setUp() throws Exception {
		
	}

}
