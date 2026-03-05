package com.allia.biblioteca.curadoria;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.allia.biblioteca.nucleo_compartilhado.Book;
import com.allia.biblioteca.nucleo_compartilhado.BookRepository;

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
	


