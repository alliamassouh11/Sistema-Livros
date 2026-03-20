package com.allia.biblioteca.curadoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/users")
public class UserController {



   // @PostMapping
    //public ResponseEntity<UserResponse> create(
      //      @RequestBody @Valid UserRequest request) {

        //UserResponse response = userService.create(request);
        //return ResponseEntity.status(HttpStatus.CREATED).body(response);
  //  }

    @GetMapping ("/")
    public ModelAndView formLogin(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("nome", "allia");
        mv.setViewName("login");
        return mv;
    }



    

}

