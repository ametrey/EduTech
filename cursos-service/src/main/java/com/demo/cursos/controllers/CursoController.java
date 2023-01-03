package com.demo.cursos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cursos.services.CursoService;

import antlr.collections.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping()
    public ResponseEntity<?> get() throws Exception {

        return new ResponseEntity<>(cursoService.findAll(), HttpStatus.OK);
    }
    
}
