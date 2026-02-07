package com.gabrieldev.apiVendas.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioDtoResponse {
    private Long id;
    private String nomeCompleto;
    //private List<PedidoDtoResponse> pedidos;
}
