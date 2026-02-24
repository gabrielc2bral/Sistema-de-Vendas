package com.gabrieldev.apiVendas.controllers;

import com.gabrieldev.apiVendas.dto.response.UsuarioDtoResponse;
import com.gabrieldev.apiVendas.mappers.UsuarioMapper;
import com.gabrieldev.apiVendas.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @GetMapping("/users/{id}")
    public ResponseEntity<UsuarioDtoResponse> buscarUsuario(@PathVariable Long id) {
        UsuarioDtoResponse usuarioDtoResponse = usuarioMapper.toDTO(usuarioService.buscarUsuario(id));
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDtoResponse);
    }

    @GetMapping("/users")
    public List<UsuarioDtoResponse> buscarTodos() {
        return usuarioService.buscarTodos();
    }
}
