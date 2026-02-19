package com.gabrieldev.apiVendas.mappers;

import com.gabrieldev.apiVendas.dto.request.ProdutoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.ProdutoDtoResponse;
import com.gabrieldev.apiVendas.entities.Produto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    Produto toEntity(ProdutoDtoRequest dto);

    ProdutoDtoResponse toDTO(Produto produto);

    List<ProdutoDtoResponse> toDTOList(List<Produto> Produto);
}
