package com.allia.biblioteca.curadoria;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.allia.biblioteca.nucleo_compartilhado.Book;
import com.allia.biblioteca.nucleo_compartilhado.BookRepository;

//import jakarta.persistence.Id;

@Service
public class BookService {

	    private final BookRepository bookRepository;

	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }

	    public List<Book> listarTodos() { //alteração aqui 
	        return bookRepository.findAll();
	    }

	    public Book buscarPorId(Long id) {
	        return bookRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
	    }

	    public Book criar(Book book) { //tem que alterar, pq o status dependende do estado
	        book.setCreatedAt(LocalDateTime.now());
	        book.setStatus("AVAILABLE"); //apoio sopode alterar o estado do livro, mas não pode criar
	        return bookRepository.save(book);
	    }

		public Book atualizar(Long id, Book bookAtualizado) {

    return bookRepository.findById(id)  //adicionar aqui o sattus do livro
        .map(bookExistente -> {          //apoio sopode alterar o estado do livro, mas não pode criar
            bookExistente.setTitle(bookAtualizado.getTitle()); 
            bookExistente.setAuthor(bookAtualizado.getAuthor());
          
            return bookRepository.save(bookExistente); 
        })
        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
	}

		public void excluir(Long id) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> 
            new RuntimeException("Livro não encontrado com o ID: " + id)
        );

    bookRepository.delete(book);
	}
}

	


