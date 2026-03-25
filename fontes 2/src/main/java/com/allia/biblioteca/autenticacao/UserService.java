package com.allia.biblioteca.autenticacao;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.allia.biblioteca.nucleo_compartilhado.UserRepository;
import com.allia.biblioteca.nucleo_compartilhado.User;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; 
}

    public boolean validarLogin(String email, String senhaPura) {
    log.info("Tentativa de login para o email: {}", email);
    
    
    return userRepository.findByEmail(email)
            .map(user -> {
                
                boolean matches = passwordEncoder.matches(senhaPura, user.getPasswordHash());
                if (matches) {
                    log.info("Login bem-sucedido para: {}", email);
                } else {
                    log.warn("Senha incorreta para o email: {}", email);
                }
                return matches;
            })
            .orElseGet(() -> {
                
                log.warn("Usuário não encontrado para o email: {}", email);
                return false;
            });
}

    public UserResponse create(UserRequest request) {
        log.info("Criando usuário com email={}", request.email());

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());

       
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        
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