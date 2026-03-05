package com.allia.biblioteca.curadoria;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allia.biblioteca.nucleo_compartilhado.Book;

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

