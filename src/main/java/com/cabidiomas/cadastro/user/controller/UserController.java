package com.cabidiomas.cadastro.user.controller;

import com.cabidiomas.cadastro.exception.UsuariocadastradoException;
import com.cabidiomas.cadastro.service.UserService;
import com.cabidiomas.cadastro.user.model.User;
import com.cabidiomas.cadastro.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public String helloWorld(){
        return "Hello world!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User salvar(@RequestBody @Valid User user) {
        try {
            return userService.salvar(user);
        }catch (UsuariocadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
