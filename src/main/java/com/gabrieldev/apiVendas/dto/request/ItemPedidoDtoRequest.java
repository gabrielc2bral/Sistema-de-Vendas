package com.gabrieldev.apiVendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDtoRequest {
    private Long produtoID;
    private Integer quantidade;
}
