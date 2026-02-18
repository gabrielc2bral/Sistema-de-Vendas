package com.gabrieldev.apiVendas.services;

import com.gabrieldev.apiVendas.dto.request.UsuarioDtoRequest;
import com.gabrieldev.apiVendas.dto.response.UsuarioDtoResponse;
import com.gabrieldev.apiVendas.entities.Usuario;
import com.gabrieldev.apiVendas.entities.enun.Role;
import com.gabrieldev.apiVendas.exceptions.EntityNotFoundException;
import com.gabrieldev.apiVendas.mappers.UsuarioMapper;
import com.gabrieldev.apiVendas.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UsuarioMapper mapper;

    public UsuarioDtoResponse cadastrarUsuario(UsuarioDtoRequest dto){
        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());
        dto.setSenha(senhaCriptografada);
        Usuario usuario = mapper.toEntity(dto);
        usuario.setRole(Role.USER);
        usuarioRepository.save(usuario);
        return mapper.toDTO(usuario);
    }

    public UsuarioDtoResponse buscarUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return mapper.toDTO(usuario);

    }

    public List<UsuarioDtoResponse> buscarTodos(){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return mapper.toDTOList(usuarioList);
    }
    public String login(String email, String senhaDigitada) {

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        String senhaDoBanco = usuario.getSenha();

        return jwtService.generateToken(usuario.getEmail(), String.valueOf(usuario.getRole()));
    }
}
