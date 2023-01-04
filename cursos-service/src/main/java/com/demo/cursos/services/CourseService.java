package com.demo.cursos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursos.dto.CourseDto;
import com.demo.cursos.entities.Course;
import com.demo.cursos.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository cRepository;
    

    public List<CourseDto> getAll() {
        return cRepository.findAll()
        .stream()
        .map(c -> new CourseDto(c.getCursoId(), c.getNombre(), c.getDescripcion()))
        .collect(Collectors.toList());
    }


    public Course getCourseById(Integer id) {
        return cRepository.findAll()
        .stream()
        .filter(c -> c.getCursoId().equals(id))
        .findFirst()
        .orElseThrow();
    }
    
}
