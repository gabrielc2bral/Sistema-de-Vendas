package com.gabrieldev.apiVendas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDtoResponse {

    private Long id;
    private Long usuarioId;
    private Long vendedorId;
    private LocalDateTime criadoEm;
    private List<ItemPedidoDtoResponse> itens;

}