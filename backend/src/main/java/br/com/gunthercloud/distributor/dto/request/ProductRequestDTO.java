package br.com.gunthercloud.distributor.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    private Long id;

    @NotNull(message = "O código de barras é obrigatório.")
    private Long barCode;

    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Size(min = 8, max = 50, message = "O nome do produto deve ter entre 8 e 50 caracteres.")
    private String name;

    @NotNull(message = "O preço do produto não pode ser nulo.")
    @Positive(message = "O preço do produto deve ser um valor positivo.")
    private Double price;

    @PositiveOrZero(message = "A quantidade em estoque tem que ser maior ou igual a 0.")
    private int stock;

    @NotBlank(message = "A URL da imagem é obrigatória.")
    private String imgUrl;

    @NotNull(message = "O id do fornecedor é obrigatório.")
    private UUID supplier;

}