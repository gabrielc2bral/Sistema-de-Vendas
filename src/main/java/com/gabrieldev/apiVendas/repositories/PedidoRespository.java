package com.gabrieldev.apiVendas.repositories;

import com.gabrieldev.apiVendas.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRespository extends JpaRepository<Pedido, Long> {
    @Query("SELECT DISTINCT p FROM Pedido p " +
            "JOIN FETCH p.usuario " +
            "WHERE p.usuario.id = :usuarioID")
    List<Pedido> findByUsuario(@Param("usuarioID") Long usuarioID);

    @Query("SELECT DISTINCT p FROM Pedido p " +
            "LEFT JOIN FETCH p.itemPedidos " +
            "LEFT JOIN FETCH itemPedidos.produto "+
            "JOIN FETCH p.usuario " +
            "JOIN FETCH p.vendedor " +
            "WHERE p.usuario.id = :usuarioID AND p.id = :pedidoID")
    Pedido findByUsuarioComPedidos(@Param("pedidoID") Long pedidoID, @Param("usuarioID") Long usuarioID);
}
