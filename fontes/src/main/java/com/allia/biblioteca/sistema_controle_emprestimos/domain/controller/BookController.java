package com.allia.biblioteca.sistema_controle_emprestimos.domain.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allia.biblioteca.sistema_controle_emprestimos.domain.entity.Book;
import com.allia.biblioteca.sistema_controle_emprestimos.domain.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listar() {
        return bookService.listarTodos();
    }

    @PostMapping
    public Book criar(@RequestBody Book book) {
        return bookService.salvar(book);
    }
}

