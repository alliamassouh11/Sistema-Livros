package com.allia.biblioteca.atendimento;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allia.biblioteca.nucleo_compartilhado.Emprestimo;

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
				request.idCliente(),
				request.idOperador()
				);
	}
}
 //registrar saida e devolver -> atualizar