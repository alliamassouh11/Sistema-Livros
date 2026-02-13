package com.allia.biblioteca.sistema_controle_emprestimos.domain.response;

import java.time.LocalDateTime;

public record BookResponse (
		 Long id,
		 
		 String title,
		 
		 String author,
		 
		 Integer publication_year,
		 
		 String status,
		 
		 LocalDateTime created_at) {}
