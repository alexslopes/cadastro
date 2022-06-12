package com.cabidiomas.cadastro.service;

import com.cabidiomas.cadastro.exception.UsuariocadastradoException;
import com.cabidiomas.cadastro.user.model.User;
import com.cabidiomas.cadastro.user.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    public UserRepository repository;

    public User salvar(User user){
        boolean exists = repository.existsByUsername(user.getUsername());
        if(exists){
            throw new UsuariocadastradoException(user.getUsername());
        }
        return repository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Login não encontrado"));
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
