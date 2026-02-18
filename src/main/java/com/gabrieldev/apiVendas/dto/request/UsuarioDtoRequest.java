package com.gabrieldev.apiVendas.dto.request;

import com.gabrieldev.apiVendas.entities.TipoDeConta;
import com.gabrieldev.apiVendas.entities.enun.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoRequest {
    @NotBlank
    @Size(max = 100)
    private String nomeCompleto;

    @NotBlank
    @Email(message = "Email inválido")
    @Size(max = 150)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    private String senha;

    @NotBlank
    @CPF(message = "O CPF informado é inválido")
    private String cpf;

    private TipoDeConta tipoDeConta;

}
