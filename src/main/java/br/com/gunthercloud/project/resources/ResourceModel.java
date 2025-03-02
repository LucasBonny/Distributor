package br.com.gunthercloud.project.resources;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ResourceModel<T, R> {
	ResponseEntity<Page<R>> findAllPaged(Pageable pageable);
	ResponseEntity<T> findById(UUID id);
	ResponseEntity<T> create(T obj);
	ResponseEntity<T> update(UUID id, T obj);
	ResponseEntity<Void> delete(UUID id);
	
}
