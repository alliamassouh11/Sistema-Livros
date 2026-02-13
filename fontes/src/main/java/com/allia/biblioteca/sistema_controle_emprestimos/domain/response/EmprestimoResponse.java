package com.allia.biblioteca.sistema_controle_emprestimos.domain.response;

import java.time.LocalDateTime;

public record EmprestimoResponse (
		
		Long id,
		
		Long bookId,
		
		String bookTitle,
		
		Long userId,
		
		String userName,
		
		LocalDateTime dataEmprestimo,
		
		LocalDateTime dataDevolucao,
		
		String status)
{}
