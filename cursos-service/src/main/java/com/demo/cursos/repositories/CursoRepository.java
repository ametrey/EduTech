package com.demo.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cursos.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
    
}
