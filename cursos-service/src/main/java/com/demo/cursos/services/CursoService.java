package com.demo.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursos.entities.Curso;
import com.demo.cursos.repositories.CursoRepository;

@Service
public class CursoService {

    @Autowired
    CursoRepository cRepository;
    

    public List<Curso> findAll() {
        return cRepository.findAll();
    }
    
}
