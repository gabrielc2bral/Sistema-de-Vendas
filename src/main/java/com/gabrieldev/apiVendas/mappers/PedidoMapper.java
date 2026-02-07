package com.gabrieldev.apiVendas.mappers;

import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponse;
import com.gabrieldev.apiVendas.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "vendedor.id", target = "vendedorId")
    PedidoDtoResponse toDTO(Pedido pedido);
}

