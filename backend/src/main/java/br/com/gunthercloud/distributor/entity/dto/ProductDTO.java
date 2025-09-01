package br.com.gunthercloud.distributor.entity.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {

    private Long id;
    private Long barCode;
    private String name;
    private Double price;
    private Integer stock;
    private String imgUrl;
    private UUID supplier;
}