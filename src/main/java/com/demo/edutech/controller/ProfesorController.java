package com.demo.edutech.controller;


import com.demo.edutech.model.Profesor;
import com.demo.edutech.service.ProfesorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorController {


    private ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }


    @PostMapping(path = "/agregar")
    public Profesor agregarProfesor(@RequestBody  Profesor profesor) {

      profesor.setId(0);
      profesorService.save(profesor);
      return profesor;
    }

    @GetMapping(path = "/listar")
    public List<Profesor> getAllProfesors() {
        return profesorService.findAll();
    }

    @GetMapping(path = "/encontrar_profesor/{id}")
    public Profesor getProfesorForId(@PathVariable  int id){
        Profesor profesor = profesorService.findById(id);

        if(profesor == null){
            throw new RuntimeException("Profesor id not found-"+ id);
        }

        return profesor;
    }

    @DeleteMapping(path = "/eliminar_profesor/{id}")
    public String deleteProfesor(@PathVariable int id) {

        Profesor profesor = profesorService.findById(id);

        if(profesor == null) {
            throw new RuntimeException("Profesor id not found -"+ id);
        }

        profesorService.deleteById(id);
        return "Deleted profesor id - "+ id;
    }

    @PutMapping("/actualizar_profesores")
    public Profesor updateUser(@RequestBody Profesor profesor) {

        profesorService.save(profesor);
        return profesor;
    }
}
