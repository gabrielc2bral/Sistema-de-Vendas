package com.gabrieldev.apiVendas.repositories;

import com.gabrieldev.apiVendas.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRespository extends JpaRepository<Pedido, Long> {
}
