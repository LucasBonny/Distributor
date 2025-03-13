package br.com.gunthercloud.project.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceModel<DTO, MinDTO, ID> {
	Page<MinDTO> findAllPaged(Pageable pageable);
	DTO findById(ID uuid);
	DTO create(DTO obj);
	DTO update(ID id, DTO obj);
	void delete(ID id);
}
