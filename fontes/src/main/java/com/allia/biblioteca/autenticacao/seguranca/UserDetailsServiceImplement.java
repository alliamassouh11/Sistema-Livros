package com.allia.biblioteca.autenticacao.seguranca;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.allia.biblioteca.nucleo_compartilhado.User;
import com.allia.biblioteca.nucleo_compartilhado.UserRepository;

@Service
public class UserDetailsServiceImplement implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));

        return new UserDetailsImplement(user);
    }

    
}