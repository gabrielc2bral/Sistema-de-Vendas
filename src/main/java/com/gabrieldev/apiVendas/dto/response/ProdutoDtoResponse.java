package com.gabrieldev.apiVendas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDtoResponse {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
