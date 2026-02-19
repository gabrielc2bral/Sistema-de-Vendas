package com.gabrieldev.apiVendas.mappers;

import com.gabrieldev.apiVendas.dto.request.ItemPedidoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.ItemPedidoDtoResponse;
import com.gabrieldev.apiVendas.entities.ItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    ItemPedido toEntity(ItemPedidoDtoRequest dto);

    @Mapping(source = "produto.id", target = "produtoId")
    @Mapping(source = "produto.nome", target = "nomeProduto")
    ItemPedidoDtoResponse toDTO(ItemPedido itemPedido);

    List<ItemPedidoDtoResponse> toDTOList(List<ItemPedido> itemPedido);
}
