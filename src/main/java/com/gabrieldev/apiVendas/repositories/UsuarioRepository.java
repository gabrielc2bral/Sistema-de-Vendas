package com.gabrieldev.apiVendas.repositories;

import com.gabrieldev.apiVendas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
