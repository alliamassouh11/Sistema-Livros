package com.allia.biblioteca.curadoria;


import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView listar() { //todos os tipos e perfis
        
        ModelAndView mv = new ModelAndView();
        List<Book> livros =  bookService.listarTodos();
        System.out.println(livros); //talvez possa descartar isso
        mv.addObject("meusLivros", livros);
        mv.setViewName("livros");
        return mv;
    }

    @PostMapping("/criar") //usa post por caus do thymeleaf 
    public String criar(Book book) { //apenas o ADMIN
        bookService.criar(book);
        return "redirect:/books";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, Book book) {
        bookService.atualizar(id, book); 
        return "redirect:/books";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        bookService.excluir(id);
        return "redirect:/books";
    }
}
//adicionar delete e put
//cadastrar, atuzalizar, ver todos, deletar livro -> serviço

//serviço ta a logica

