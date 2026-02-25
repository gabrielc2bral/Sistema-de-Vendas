package com.gabrieldev.apiVendas.services;

import com.gabrieldev.apiVendas.dto.request.ProdutoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.ProdutoDtoResponse;
import com.gabrieldev.apiVendas.entities.Produto;
import com.gabrieldev.apiVendas.exceptions.EntityNotFoundException;
import com.gabrieldev.apiVendas.mappers.ProdutoMapper;
import com.gabrieldev.apiVendas.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {


    private final ProdutoRepository produtoRepository;

    private final ProdutoMapper mapper;

    public ProdutoDtoResponse criarProduto(ProdutoDtoRequest dtoRequest){
        Produto produto = mapper.toEntity(dtoRequest);
        produtoRepository.save(produto);
        return mapper.toDTO(produto);
    }
    
    public Produto buscarProduto (Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não existe"));
        return produto;
    }

    public List<Produto> buscarTodosOsProdutps (){
        return produtoRepository.findAll();
    }

}
