package br.com.gunthercloud.project.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceModel<T, R> {
	Page<R> findAllPaged(Pageable pageable);
	T findById(UUID uuid);
	T create(T obj);
	T update(UUID id, T obj);
	void delete(UUID id);
}
