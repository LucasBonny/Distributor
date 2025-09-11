package br.com.gunthercloud.distributor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponseDTO extends DeliveryResponseSimpleDTO {

    private Set<DeliveryItemResponseSimpleDTO> items = new HashSet<>();

}
