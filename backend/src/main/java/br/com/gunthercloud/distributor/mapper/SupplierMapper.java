package br.com.gunthercloud.distributor.mapper;

import br.com.gunthercloud.distributor.dto.request.ProductRequestDTO;
import br.com.gunthercloud.distributor.dto.request.SupplierRequestDTO;
import br.com.gunthercloud.distributor.dto.response.ProductResponseDTO;
import br.com.gunthercloud.distributor.dto.response.SupplierResponseSimpleDTO;
import br.com.gunthercloud.distributor.entity.Product;
import org.springframework.beans.BeanUtils;

import br.com.gunthercloud.distributor.entity.Supplier;
import br.com.gunthercloud.distributor.dto.response.SupplierResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    @Autowired
    private ProductMapper pMapper;

    public SupplierResponseSimpleDTO supplierToSimpleDTO(Supplier entity) {
        SupplierResponseSimpleDTO responseDTO = new SupplierResponseSimpleDTO();
        BeanUtils.copyProperties(entity, responseDTO);
        return responseDTO;
    }

    public SupplierResponseDTO supplierToDTO(Supplier entity) {
        SupplierResponseDTO responseDTO = new SupplierResponseDTO();
        BeanUtils.copyProperties(entity, responseDTO);
        if(!entity.getProducts().isEmpty())
            for(Product product : entity.getProducts()) {
                responseDTO.getProducts().add(pMapper.productToDTO(product));
            }
        return responseDTO;
    }

	public Supplier supplierToEntity(SupplierRequestDTO requestDTO) {
		Supplier entity = new Supplier();
		BeanUtils.copyProperties(requestDTO, entity);
        if(!requestDTO.getProducts().isEmpty())
            for(ProductRequestDTO product : requestDTO.getProducts()) {
                entity.addProduct(pMapper.productToEntity(product));
            }
		return entity;
	}

}
