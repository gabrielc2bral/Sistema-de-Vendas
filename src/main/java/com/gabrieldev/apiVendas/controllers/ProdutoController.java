package com.gabrieldev.apiVendas.controllers;

import com.gabrieldev.apiVendas.dto.request.ProdutoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.ProdutoDtoResponse;
import com.gabrieldev.apiVendas.entities.Produto;
import com.gabrieldev.apiVendas.mappers.ProdutoMapper;
import com.gabrieldev.apiVendas.services.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;
    private final ProdutoMapper produtoMapper;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProdutoDtoResponse> criarProduto(@Valid @RequestBody ProdutoDtoRequest dtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(dtoRequest));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public ResponseEntity<?> buscarProduto(@RequestParam(required = false) Long id) {
        if (id != null) {
            ProdutoDtoResponse produtoDtoResponse = produtoMapper.toDTO(produtoService.buscarProduto(id));
            return ResponseEntity.status(HttpStatus.OK).body(produtoDtoResponse);
        }
        List<ProdutoDtoResponse> produtoDtoResponseList = produtoMapper.toDTOList(produtoService.buscarTodosOsProdutps());
        return ResponseEntity.status(HttpStatus.OK).body(produtoDtoResponseList);
    }
}
