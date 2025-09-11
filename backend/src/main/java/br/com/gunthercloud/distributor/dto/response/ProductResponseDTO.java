package br.com.gunthercloud.distributor.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private Long id;

    @NotNull(message = "O código de barras é obrigatório.")
    private Long barCode;

    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Size(min = 8, max = 50, message = "O nome do produto deve ter entre 8 e 50 caracteres.")
    private String name;

    @NotNull(message = "O preço do produto não pode ser nulo.")
    @Positive(message = "O preço do produto deve ser um valor positivo.")
    private Double price;

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @Positive(message = "A quantidade em estoque tem que ser maior que 0.")
    private Integer stock;

    @NotBlank(message = "A URL da imagem é obrigatória.")
    private String imgUrl;

    @NotNull(message = "O id do fornecedor é obrigatório.")
    @JsonIgnore
    private UUID supplier;

}