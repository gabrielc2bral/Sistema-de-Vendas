package com.gabrieldev.apiVendas.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ItemPedidoDtoResponse {
    private Long id;
    private Long produtoId;
    private String nomeProduto;
    private int quantidade;
    private BigDecimal precoUnitario;

}

