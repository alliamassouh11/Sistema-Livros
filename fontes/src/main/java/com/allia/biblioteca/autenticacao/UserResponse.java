package com.allia.biblioteca.autenticacao;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String name,
        String email,
        Boolean active,
        LocalDateTime createdAt
) {}
