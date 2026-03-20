package com.allia.biblioteca.curadoria;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.allia.biblioteca.nucleo_compartilhado.Book;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView listar() {
        
        ModelAndView mv = new ModelAndView();
        List<Book> livros =  bookService.listarTodos();
        System.out.println(livros); //talvez possa descartar isso
        mv.addObject("meusLivros", livros);
        mv.setViewName("livros");
        return mv;
    }

    @PostMapping("/criar")
    public Book criar(@RequestBody Book book) {
        return bookService.criar(book);
    }

    @PostMapping("/atualizar/{id}")
    public Book atualizar(@RequestBody Book book) {
        return bookService.atualizar(null, book);
    }

} 
//adicionar delete e put
//cadastrar, atuzalizar, ver todos, deletar livro -> serviço

//serviço ta a logica

