package com.gabrieldev.apiVendas.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDtoRequest {
    @NotBlank
    private String nome;
    @Min(1)
    private BigDecimal preco;
    @NotNull
    private Integer quantidade = 0;
}
