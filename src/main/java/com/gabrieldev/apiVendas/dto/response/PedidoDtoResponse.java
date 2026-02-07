package com.gabrieldev.apiVendas.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class PedidoDtoResponse {

    private Long id;
    private Long usuarioId;
    private Long vendedorId;
    private LocalDateTime criadoEm;
    private List<ItemPedidoDtoResponse> itens;

}