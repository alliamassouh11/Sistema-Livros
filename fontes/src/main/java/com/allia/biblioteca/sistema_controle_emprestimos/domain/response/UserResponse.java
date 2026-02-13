package com.allia.biblioteca.sistema_controle_emprestimos.domain.response;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String name,
        String email,
        Boolean active,
        LocalDateTime createdAt
) {}
