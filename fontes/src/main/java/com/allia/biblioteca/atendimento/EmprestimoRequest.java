package com.allia.biblioteca.atendimento;

public record EmprestimoRequest (
		Long idLivro,
		String nomeLivro, 
		Long idCliente, 
		Long idOperador
) {
		
	
}
