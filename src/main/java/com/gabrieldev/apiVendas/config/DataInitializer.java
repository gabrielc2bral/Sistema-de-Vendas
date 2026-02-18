package com.gabrieldev.apiVendas.config;

import com.gabrieldev.apiVendas.entities.TipoDeConta;
import com.gabrieldev.apiVendas.entities.Usuario;
import com.gabrieldev.apiVendas.entities.enun.Role;
import com.gabrieldev.apiVendas.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner initAdmin(UsuarioRepository repository) {
        return args -> {

            if (repository.findByEmail("admin@sistema.com").isEmpty()) {

                Usuario admin = new Usuario();
                admin.setNomeCompleto("Administrador Sistema");
                admin.setEmail("admin@sistema.com");
                admin.setSenha(passwordEncoder.encode("187574554@admin77752270"));
                admin.setCpf("11122233344");
                admin.setTipoDeConta(TipoDeConta.CLIENTE);
                admin.setRole(Role.ADMIN);

                repository.save(admin);
            }
        };
    }
}
