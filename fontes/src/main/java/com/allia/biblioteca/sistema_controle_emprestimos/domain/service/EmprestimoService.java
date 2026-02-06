package com.allia.biblioteca.sistema_controle_emprestimos.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Book;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Emprestimo;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.User;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.BookRepository;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final BookRepository bookRepository;

    public EmprestimoService(
        EmprestimoRepository emprestimoRepository,
        BookRepository bookRepository
    ) {
        this.emprestimoRepository = emprestimoRepository;
        this.bookRepository = bookRepository;
    }

    public Emprestimo emprestar(Book book, User borrower, User operator) {

        if (!"AVAILABLE".equals(book.getStatus())) {
            throw new RuntimeException("Livro não disponível para empréstimo");
        }

        book.setStatus("LOANED");
        bookRepository.save(book);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setBook(book);
        emprestimo.setBorrower(borrower);
        emprestimo.setOperator(operator);
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
}
