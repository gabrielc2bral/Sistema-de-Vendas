package com.gabrieldev.apiVendas.mappers;

import com.gabrieldev.apiVendas.dto.request.PedidoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponse;
import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponseResumo;
import com.gabrieldev.apiVendas.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ItemPedidoMapper.class)
public interface PedidoMapper {

    @Mapping(source = "vendedorID", target = "vendedor.id")
    @Mapping(target = "itemPedidos", ignore = true)
    Pedido toEntity(PedidoDtoRequest dto);


    PedidoDtoResponse toDTO(Pedido pedido);

    PedidoDtoResponseResumo toDTOResumo(Pedido pedido);

    List<PedidoDtoResponse> toDTOList(List<Pedido> pedido);
}
