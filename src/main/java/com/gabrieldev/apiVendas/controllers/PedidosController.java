package com.gabrieldev.apiVendas.controllers;

import com.gabrieldev.apiVendas.dto.request.PedidoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponse;
import com.gabrieldev.apiVendas.entities.Usuario;
import com.gabrieldev.apiVendas.services.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidosController {
    private final PedidoService pedidoService;

    @PostMapping("/")
    public ResponseEntity<PedidoDtoResponse> criarPedido(@Valid @RequestBody PedidoDtoRequest dtoRequest, Authentication authentication){
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        System.out.println(usuarioLogado.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.criarPedido(dtoRequest, usuarioLogado));
    }
}
