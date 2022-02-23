package com.cabidiomas.cadastro.user.controller;

import com.cabidiomas.cadastro.user.model.User;
import com.cabidiomas.cadastro.user.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String helloWorld(){
        return "Hello world!";
    }

    @PostMapping
    public User salvar(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }
}
