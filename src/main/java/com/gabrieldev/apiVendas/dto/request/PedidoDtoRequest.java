package com.gabrieldev.apiVendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDtoRequest {
    private Long vendedorID;
    private List<ItemPedidoDtoRequest> itemPedidoList;
}


