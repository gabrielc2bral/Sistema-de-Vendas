package com.gabrieldev.apiVendas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@Data
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Poderia colocar um uuid no futuro
    private long id;

    private String nomeCompleto;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private TipoDeConta tipoDeConta;

    private String email;

    private String senha;

}
