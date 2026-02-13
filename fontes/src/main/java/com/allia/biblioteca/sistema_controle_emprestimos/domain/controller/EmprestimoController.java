package com.allia.biblioteca.sistema_controle_emprestimos.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Emprestimo;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.response.EmprestimoRequest;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.service.EmprestimoService;

@Controller
@RequestMapping ("/loans")

public class EmprestimoController {
	
	private EmprestimoService emprestimoService;
	
	public EmprestimoController(EmprestimoService emprestimoService) {
		this.emprestimoService = emprestimoService;
	}

	@PostMapping("/emprestar")
	public Emprestimo emprestar(@RequestBody EmprestimoRequest request) {
		return emprestimoService.emprestar(
				request.idLivro(),
				request.nomeLivro(),
				request.idCliente(),
				request.idOperador()
				);
	}
}
