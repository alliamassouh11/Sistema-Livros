package com.allia.biblioteca.curadoria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.allia.biblioteca.autenticacao.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String formLogin() {
        return "login"; 
    }

    @PostMapping("/login")
    public ModelAndView autenticar(String email, String senha) {
        ModelAndView mv = new ModelAndView();
        
        boolean autenticado = userService.validarLogin(email, senha);

        if (autenticado) {
            mv.setViewName("redirect:/books"); 
        } else {
            mv.setViewName("login");
            mv.addObject("erro", "Credenciais inválidas");
        }
        
        return mv;
    }

}