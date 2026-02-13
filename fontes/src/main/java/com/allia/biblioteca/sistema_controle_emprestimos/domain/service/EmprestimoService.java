package com.allia.biblioteca.sistema_controle_emprestimos.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Book;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Emprestimo;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.User;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.BookRepository;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.EmprestimoRepository;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.UserRepository;


@Service
public class EmprestimoService {

    private  EmprestimoRepository emprestimoRepository;
    private  BookRepository bookRepository;
    private final UserRepository userRepository;


    public EmprestimoService(
        EmprestimoRepository emprestimoRepository,
        BookRepository bookRepository,
        UserRepository userRepository
    ) {
        this.emprestimoRepository = emprestimoRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Emprestimo emprestar(Long idLivro, Long idCliente, Long idOperador) {

        Book book = bookRepository.findById(idLivro)
            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (!"AVAILABLE".equals(book.getStatus())) {
            throw new RuntimeException("Livro não disponível para empréstimo");
        }

        User cliente = userRepository.findById(idCliente)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        User operador = userRepository.findById(idOperador)
            .orElseThrow(() -> new RuntimeException("Operador não encontrado"));

        book.setStatus("LOANED");
        bookRepository.save(book);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setBook(book);
        emprestimo.setBorrower(cliente);
        emprestimo.setOperator(operador);
        emprestimo.setLoanDate(LocalDateTime.now());
        emprestimo.setStatus("OPEN");

        return emprestimoRepository.save(emprestimo);
    }


    public Emprestimo devolver(Long emprestimoId) {

        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
            .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        emprestimo.setReturnDate(LocalDateTime.now());
        emprestimo.setStatus("CLOSED");

        Book book = emprestimo.getBook();
        book.setStatus("AVAILABLE");
        bookRepository.save(book);

        return emprestimo;
    }

	public Emprestimo emprestar(Long idLivro, String nomeLivro, Long idCliente, Long idOperador) {
		// TODO Auto-generated method stub
		return null;
	}
}
