package com.allia.biblioteca.sistema_controle_emprestimos.domain.response;

public record EmprestimoRequest (
		Long idLivro,
		String nomeLivro, 
		Long idCliente, 
		Long idOperador
) {
		
	
}
