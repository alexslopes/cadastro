package com.cabidiomas.cadastro.user.controller;

import com.cabidiomas.cadastro.user.controller.dto.CursoDto;
import com.cabidiomas.cadastro.user.model.Aluno;
import com.cabidiomas.cadastro.user.model.AlunoRepository;
import com.cabidiomas.cadastro.user.model.Curso;
import com.cabidiomas.cadastro.user.model.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos ")
@RequiredArgsConstructor
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    private AlunoRepository alunoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso salvar(@RequestBody @Valid CursoDto dto) {
        Integer idAluno = dto.getIdAluno();

        Aluno aluno =
                alunoRepository
                        .findById(idAluno)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));

        Curso curso = new Curso();
        curso.setDescricao(dto.getDescricao());

        return cursoRepository.save(curso);
    }
}
