package com.cabidiomas.cadastro.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("select c from Curso c " +
            " where upper( c.nome ) like upper( :nome )")
    List<Curso> findByNome( @Param("nome") String nome);
}
