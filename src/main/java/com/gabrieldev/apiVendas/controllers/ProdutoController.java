package com.gabrieldev.apiVendas.controllers;

import com.gabrieldev.apiVendas.dto.request.ProdutoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.ProdutoDtoResponse;
import com.gabrieldev.apiVendas.services.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {
    private ProdutoService produtoService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProdutoDtoResponse> criarProduto(@Valid @RequestBody ProdutoDtoRequest dtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(dtoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDtoResponse> buscarProduto(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarProduto(id));
    }
}
