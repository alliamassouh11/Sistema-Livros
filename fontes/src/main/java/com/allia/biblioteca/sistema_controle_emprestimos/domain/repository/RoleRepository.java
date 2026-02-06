package com.allia.biblioteca.sistema_controle_emprestimos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
