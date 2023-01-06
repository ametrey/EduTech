package com.demo.alumnos.controller;

import com.demo.alumnos.dto.AlumnoDto;
import com.demo.alumnos.exceptions.DataAlreadyExistException;
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
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) throws DataAlreadyExistException {
        try{
            alumnoService.createAlumno(alumno);
            return ResponseEntity.ok(alumno);
        }catch(DataAlreadyExistException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST );
        }

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
            return ResponseEntity.badRequest().body( HttpStatus.BAD_REQUEST + "Alumno No encontrado ");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Alumno> updateAlumno(@RequestBody AlumnoDto alumnoDto){
        Alumno alumnoNew = new Alumno();
        try {
            alumnoNew = alumnoService.updateAlumno(alumnoDto);
            return ResponseEntity.ok(alumnoNew);
        } catch (NoEntityException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(alumnoNew);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable("id") Long id){
        try {
            alumnoService.deleteAlumno(id);
            return ResponseEntity.ok("Alumno Eliminado");
        } catch (NoEntityException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body( HttpStatus.BAD_REQUEST + "Alumno No Eliminado");
        }
    }


}
