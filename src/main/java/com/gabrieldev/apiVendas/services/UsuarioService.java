package com.gabrieldev.apiVendas.services;

import com.gabrieldev.apiVendas.dto.request.UsuarioDtoRequest;
import com.gabrieldev.apiVendas.dto.response.UsuarioDtoResponse;
import com.gabrieldev.apiVendas.entities.Usuario;
import com.gabrieldev.apiVendas.mappers.UsuarioMapper;
import com.gabrieldev.apiVendas.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private UsuarioMapper mapper;

    public UsuarioDtoResponse criarUsuario(UsuarioDtoRequest dto){
        Usuario usuario = mapper.toEntity(dto);
        usuarioRepository.save(usuario);
        return mapper.toDTO(usuario);
    }

    public UsuarioDtoResponse buscarUsuario(Long id){
        return mapper.toDTO(usuarioRepository.findById(id).orElseThrow());
    }

    public List<UsuarioDtoResponse> buscarTodos(){
        List<Usuario> usuarioList = usuarioRepository.findAllWithPedidos();
        return mapper.toDTOList(usuarioList);
    }
}
