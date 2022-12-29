package com.demo.alumnos.controller;

import com.demo.alumnos.exceptions.NoEntityException;
import com.demo.alumnos.model.Alumno;
import com.demo.alumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping(value = "create")
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
        Alumno alumnoNew = alumnoService.createAlumno(alumno);
        return new ResponseEntity<Alumno>(alumnoNew, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Alumno>> getAlumnos(){
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlumnoById(@PathVariable("id") Long id) {

        try {
            Alumno alumno = alumnoService.findById(id);
            return ResponseEntity.ok(alumno);
        } catch (NoEntityException e) {
            System.out.println(e.getMessage());
            //return new ResponseEntity<>("Student No encontrado", HttpStatusCode.valueOf(400));
            return ResponseEntity.badRequest().body( HttpStatus.BAD_REQUEST + "Alumno No encontrado ");
        }
    }

}
