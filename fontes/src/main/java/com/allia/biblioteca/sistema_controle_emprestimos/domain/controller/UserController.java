package com.allia.biblioteca.sistema_controle_emprestimos.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allia.biblioteca.sistema_controle_emprestimos.domain.response.UserRequest;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.response.UserResponse;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @RequestBody @Valid UserRequest request) {

        UserResponse response = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

