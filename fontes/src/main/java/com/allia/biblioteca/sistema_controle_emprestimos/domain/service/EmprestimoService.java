package com.allia.biblioteca.sistema_controle_emprestimos.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Book;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Emprestimo;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.User;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.excecao.BusinessException;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.BookRepository;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.EmprestimoRepository;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, 
                             BookRepository bookRepository, 
                             UserRepository userRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Transactional 
    public Emprestimo emprestar(Long idLivro, Long idCliente, Long idOperador) {

        Book book = bookRepository.findById(idLivro)
            .orElseThrow(() -> new EntityNotFoundException("Livro ID " + idLivro + " não encontrado"));

        if (!"AVAILABLE".equals(book.getStatus())) {
            throw new BusinessException("O livro '" + book.getTitle() + "' já está emprestado.");
        }

        User cliente = userRepository.findById(idCliente)
            .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        User operador = userRepository.findById(idOperador)
            .orElseThrow(() -> new EntityNotFoundException("Operador não encontrado"));

        
        book.setStatus("LOANED");
        bookRepository.save(book);

        
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setBook(book);
        emprestimo.setBorrower(cliente);
        emprestimo.setOperator(operador);
        emprestimo.setLoanDate(LocalDateTime.now());
        emprestimo.setReturnDate(LocalDateTime.now().plusDays(10));
        emprestimo.setStatus("OPEN");

        return emprestimoRepository.save(emprestimo);
    }

    @Transactional
    public Emprestimo devolver(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
            .orElseThrow(() -> new EntityNotFoundException("Empréstimo não encontrado"));

        if ("CLOSED".equals(emprestimo.getStatus())) {
            throw new BusinessException("Este empréstimo já foi encerrado anteriormente.");
        }

    
        emprestimo.setReturnDate(LocalDateTime.now());
        emprestimo.setStatus("CLOSED");
        
        
        Book book = emprestimo.getBook();
        book.setStatus("AVAILABLE");

        return emprestimoRepository.save(emprestimo);
    }
}