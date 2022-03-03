package com.cabidiomas.cadastro.user.controller;

import com.cabidiomas.cadastro.user.model.Aluno;
import com.cabidiomas.cadastro.user.model.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private  AlunoRepository repository;

    @GetMapping
    public List<Aluno> obterTodos() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar( @RequestBody @Valid Aluno aluno){
        return repository.save(aluno);
    }

    @GetMapping("{id}")
    public Aluno acharPorId( @PathVariable Integer id){
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id){
        repository.findById(id).
                map( aluno -> {
                    repository.delete(aluno);
                    return Void.TYPE;
                }).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado") );
    }

    @PutMapping("{id}")//Utilizado para atualizar recurso
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id, @RequestBody @Valid Aluno alunoAtualizado ) {
        repository.findById(id).
                map( cliente -> {
                    alunoAtualizado.setNome(alunoAtualizado.getNome());
                    alunoAtualizado.setCpf(alunoAtualizado.getCpf());
                    return repository.save(alunoAtualizado);
                }).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado") );
    }
}
