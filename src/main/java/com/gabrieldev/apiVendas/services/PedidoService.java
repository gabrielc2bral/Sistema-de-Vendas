package com.gabrieldev.apiVendas.services;

import com.gabrieldev.apiVendas.dto.request.ItemPedidoDtoRequest;
import com.gabrieldev.apiVendas.dto.request.PedidoDtoRequest;
import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponse;
import com.gabrieldev.apiVendas.dto.response.PedidoDtoResponseResumo;
import com.gabrieldev.apiVendas.entities.ItemPedido;
import com.gabrieldev.apiVendas.entities.Pedido;
import com.gabrieldev.apiVendas.entities.Produto;
import com.gabrieldev.apiVendas.entities.Usuario;
import com.gabrieldev.apiVendas.exceptions.EstoqueInsuficienteException;
import com.gabrieldev.apiVendas.mappers.ItemPedidoMapper;
import com.gabrieldev.apiVendas.mappers.PedidoMapper;
import com.gabrieldev.apiVendas.repositories.PedidoRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PedidoService {
    private final PedidoRespository pedidoRespository;
    private final ProdutoService produtoService;
    private final UsuarioService usuarioService;
    private final PedidoMapper pedidoMapper;
    private final ItemPedidoMapper itemPedidoMapper;

    @Transactional
    public PedidoDtoResponse criarPedido(PedidoDtoRequest dtoRequest, Usuario usuario) {
        if (dtoRequest.getItemPedidoList() == null || dtoRequest.getItemPedidoList().isEmpty()) {
            throw new RuntimeException("Não é possível criar um pedido sem itens.");
        }
        Usuario vendedor = usuarioService.buscarUsuario(dtoRequest.getVendedorID());
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setVendedor(vendedor);
        pedido.setCriadoEm(LocalDateTime.now());
        Map<Long, Integer> itensAgrupados = new HashMap<>();
        for (ItemPedidoDtoRequest itemDto : dtoRequest.getItemPedidoList()) {
            Long id = itemDto.getProdutoID();
            Integer qtd = itemDto.getQuantidade();
            if (itensAgrupados.containsKey(id)) {
                itensAgrupados.put(id, itensAgrupados.get(id) + qtd);
            } else {
                itensAgrupados.put(id, qtd);
            }
        }

        for (Map.Entry<Long, Integer> entry : itensAgrupados.entrySet()) {
            Long produtoId = entry.getKey();
            Integer quantidadeTotal = entry.getValue();
            if (quantidadeTotal == 0) throw new RuntimeException();
            Produto produto = produtoService.buscarProduto(produtoId);
            if (produto.getQuantidade() < quantidadeTotal)
                throw new EstoqueInsuficienteException("Estoque insuficiente para o produto: " + produto.getNome());
            produto.setQuantidade(produto.getQuantidade() - quantidadeTotal);
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(quantidadeTotal);
            itemPedido.setPrecoUnitario(produto.getPreco());
            pedido.setTotal(pedido.getTotal().add(itemPedido.getPrecoUnitario().multiply(BigDecimal.valueOf(quantidadeTotal))));
            pedido.adicionarItem(itemPedido);
        }
        pedidoRespository.save(pedido);
        return pedidoMapper.toDTO(pedido);
    }

    public List<PedidoDtoResponse> buscarPedidos(Usuario usuario) {
        List<Pedido> entidades = pedidoRespository.findByUsuario(usuario.getId());
        return pedidoMapper.toDTOList(entidades);
    }

    public PedidoDtoResponseResumo buscarPedidoComItens(Long pedidoID, Long usuarioID) {
        Pedido pedido =  pedidoRespository.findByUsuarioComPedidos(pedidoID, usuarioID);
        return  pedidoMapper.toDTOResumo(pedido);
    }
}
