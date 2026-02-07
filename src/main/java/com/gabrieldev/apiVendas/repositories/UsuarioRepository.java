package com.gabrieldev.apiVendas.repositories;

import com.gabrieldev.apiVendas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("""
    SELECT DISTINCT u
    FROM Usuario u
    LEFT JOIN FETCH u.pedidos p
    LEFT JOIN FETCH p.itemPedidos
    """)
    List<Usuario> findAllWithPedidos();
}
