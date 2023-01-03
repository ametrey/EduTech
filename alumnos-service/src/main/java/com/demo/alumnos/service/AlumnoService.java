package com.demo.alumnos.service;


import com.demo.alumnos.dto.AlumnoDto;
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

    public Alumno updateAlumno(AlumnoDto alumnoDto) throws NoEntityException {
        Alumno alumnoNew = alumnoRepository.findById(alumnoDto.getId()).orElseThrow(
                () -> new NoEntityException("No existe Alumno con " + alumnoDto.getId()));
        alumnoNew.setApellido(alumnoDto.getApellido());
        alumnoNew.setNombre(alumnoDto.getNombre());
        alumnoNew.setDni(alumnoDto.getDni());
        return alumnoRepository.save(alumnoNew);
    }

    public void deleteAlumno(Long id) throws NoEntityException {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(() -> new NoEntityException("No existe Alumno con " + id));
        alumnoRepository.delete(alumno);
    }
}