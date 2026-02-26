package com.allia.biblioteca.sistema_controle_emprestimos.domain.excecao;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
