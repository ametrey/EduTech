package com.demo.alumnos.service;


import com.demo.alumnos.exceptions.NoEntityException;
import com.demo.alumnos.model.Alumno;
import com.demo.alumnos.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;


    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Long id) throws NoEntityException {
        return alumnoRepository.findById(id).orElseThrow(() -> new NoEntityException("No existe Alumno con " + id));
    }

    public Alumno updateAlumno(Alumno alumno) throws NoEntityException {
        Alumno alumnoNew = alumnoRepository.findById(alumno.getId()).orElseThrow(
                () -> new NoEntityException("No existe Alumno con " + alumno.getId()));
        alumnoNew.setApellido(alumno.getApellido());
        alumnoNew.setNombre(alumno.getNombre());
        alumnoNew.setDni(alumno.getDni());
        return alumnoRepository.save(alumnoNew);
    }

    public void deleteAlumno(Long id) throws NoEntityException {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(() -> new NoEntityException("No existe Alumno con " + id));
        alumnoRepository.delete(alumno);
    }
}