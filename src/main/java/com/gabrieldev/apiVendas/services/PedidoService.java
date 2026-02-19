package com.gabrieldev.apiVendas.services;

import com.gabrieldev.apiVendas.dto.request.ItemPedidoDtoRequest;
import com.gabrieldev.apiVendas.dto.request.PedidoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponse;
import com.gabrieldev.apiVendas.entities.ItemPedido;
import com.gabrieldev.apiVendas.entities.Pedido;
import com.gabrieldev.apiVendas.entities.Produto;
import com.gabrieldev.apiVendas.entities.Usuario;
import com.gabrieldev.apiVendas.exceptions.EntityNotFoundException;
import com.gabrieldev.apiVendas.mappers.ItemPedidoMapper;
import com.gabrieldev.apiVendas.mappers.PedidoMapper;
import com.gabrieldev.apiVendas.repositories.PedidoRespository;
import com.gabrieldev.apiVendas.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PedidoService {
    private final PedidoRespository pedidoRespository;
    private final ProdutoRepository produtoRepository;
    private final PedidoMapper pedidoMapper;
    private final ItemPedidoMapper itemPedidoMapper;

    @Transactional
    public PedidoDtoResponse criarPedido(PedidoDtoRequest dtoRequest, Usuario usuario){
        if (dtoRequest.getItemPedidoList() == null || dtoRequest.getItemPedidoList().isEmpty()) {
            throw new RuntimeException("Não é possível criar um pedido sem itens.");
        }
        Pedido pedido = pedidoMapper.toEntity(dtoRequest);
        pedido.setUsuario(usuario);
        pedido.setCriadoEm(LocalDateTime.now());
        for (ItemPedido item : pedido.getItemPedidos()) {
            System.out.println("Pedido dentro do item: " + item.getPedido());
        }
        for(ItemPedidoDtoRequest itemDto : dtoRequest.getItemPedidoList()){
            Produto produto = produtoRepository.findById(itemDto.getProdutoID()).orElseThrow(() -> new EntityNotFoundException("Produto Não encontrado"));
            ItemPedido itemPedido = itemPedidoMapper.toEntity(itemDto);
            itemPedido.setProduto(produto);
            pedido.adicionarItem(itemPedido);
        }
        pedidoRespository.save(pedido);
        return pedidoMapper.toDTO(pedido);
    }
}
