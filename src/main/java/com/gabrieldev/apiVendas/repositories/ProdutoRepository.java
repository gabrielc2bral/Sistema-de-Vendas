package com.gabrieldev.apiVendas.repositories;

import com.gabrieldev.apiVendas.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
