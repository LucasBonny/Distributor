package br.com.gunthercloud.project.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ResourceModel<DTO, MinDTO, ID> {
	ResponseEntity<Page<MinDTO>> findAllPaged(Pageable pageable);
	ResponseEntity<DTO> findById(ID id);
	ResponseEntity<DTO> create(DTO obj);
	ResponseEntity<DTO> update(ID id, DTO obj);
	ResponseEntity<Void> delete(ID id);
	
}
