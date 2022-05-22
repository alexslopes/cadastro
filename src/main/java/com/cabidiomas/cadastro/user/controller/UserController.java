package com.cabidiomas.cadastro.user.controller;

import com.cabidiomas.cadastro.user.model.User;
import com.cabidiomas.cadastro.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @GetMapping
    public String helloWorld(){
        return "Hello world!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User salvar(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }
}
