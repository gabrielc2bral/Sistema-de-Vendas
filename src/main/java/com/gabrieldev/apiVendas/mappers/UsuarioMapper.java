package com.gabrieldev.apiVendas.mappers;


import com.gabrieldev.apiVendas.dto.request.UsuarioDtoRequest;
import com.gabrieldev.apiVendas.dto.response.UsuarioDtoResponse;
import com.gabrieldev.apiVendas.entities.Usuario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = PedidoMapper.class)
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDtoRequest dto);

    UsuarioDtoResponse toDTO(Usuario usuario);

    List<UsuarioDtoResponse> toDTOList(List<Usuario> usuarios);
}
