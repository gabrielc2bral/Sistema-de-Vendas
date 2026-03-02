package com.gabrieldev.apiVendas.controllers;

import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponse;
import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponseResumo;
import com.gabrieldev.apiVendas.entities.Usuario;
import com.gabrieldev.apiVendas.services.PedidoService;
import com.gabrieldev.apiVendas.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/me")
public class UsuarioController {
    private UsuarioService usuarioService;
    private PedidoService pedidoService;

    @GetMapping("")
    public String usuarioLogado(Authentication authentication) {
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        return String.format("Olá %s", usuarioLogado.getNomeCompleto());
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoDtoResponse>> buscarPedidos(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.buscarPedidos(usuario));
    }

    @GetMapping("/pedidos/{id}/itens-pedido")
    public ResponseEntity<PedidoDtoResponseResumo> buscarPedidosComOsItens(@RequestParam Long pedidoID, Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.buscarPedidoComItens(pedidoID, usuario.getId()));
    }

}
