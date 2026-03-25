package com.allia.biblioteca.autenticacao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(

        @NotBlank(message = "Nome é obrigatório")
        String name,

        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String password
) {}
