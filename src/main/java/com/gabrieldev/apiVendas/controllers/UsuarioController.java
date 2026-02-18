package com.gabrieldev.apiVendas.controllers;

import com.gabrieldev.apiVendas.dto.request.UsuarioDtoRequest;
import com.gabrieldev.apiVendas.dto.response.UsuarioDtoResponse;
import com.gabrieldev.apiVendas.entities.Usuario;
import com.gabrieldev.apiVendas.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    @GetMapping("/me")
    public String usuarioLogado(Authentication authentication) {
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        return String.format("Olá %s", usuarioLogado.getNomeCompleto());
    }



}
