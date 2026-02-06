package com.allia.biblioteca.sistema_controle_emprestimos.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Book;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.repository.BookRepository;

@Service
public class BookService {

	    private final BookRepository bookRepository;

	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }

	    public List<Book> listarTodos() {
	        return bookRepository.findAll();
	    }

	    public Book buscarPorId(Long id) {
	        return bookRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
	    }

	    public Book salvar(Book book) {
	        book.setCreatedAt(LocalDateTime.now());
	        book.setStatus("AVAILABLE");
	        return bookRepository.save(book);
	    }
	}
	


