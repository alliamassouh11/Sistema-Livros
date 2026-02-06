package com.allia.biblioteca.sistema_controle_emprestimos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
