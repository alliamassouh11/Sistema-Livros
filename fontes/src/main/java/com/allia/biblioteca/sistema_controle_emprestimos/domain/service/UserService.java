package com.allia.biblioteca.sistema_controle_emprestimos.domain.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.User;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.UserRepository;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.response.UserRequest;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.response.UserResponse;

@Service
public class UserService {

    private final UserRepository userRepository;

    private static final Logger log =
            LoggerFactory.getLogger(UserService.class);

    // 🔹 Construtor manual
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse create(UserRequest request) {

        log.info("Criando usuário com email={}", request.email());

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return toResponse(user);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getActive(),
                user.getCreatedAt()
        );
    }
}
