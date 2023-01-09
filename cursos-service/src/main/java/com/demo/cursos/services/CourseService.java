package com.demo.cursos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursos.dto.CourseCreationDTO;
import com.demo.cursos.dto.CourseDTO;
import com.demo.cursos.dto.Mapper;
import com.demo.cursos.entities.Course;
import com.demo.cursos.exceptions.NotFound;
import com.demo.cursos.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository cRepository;

    @Autowired
    Mapper mapper;

    public List<CourseDTO> getAll() {
        return cRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseDTOById(Integer id) {
        return cRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFound(id));
    }

    public void createCourse(CourseCreationDTO dto) {
        cRepository.save(mapper.toCourse(dto));
    }

    public CourseDTO updateCourse(Integer id, CourseCreationDTO course) {
        Course c = cRepository.findById(id).orElseThrow(() -> new NotFound(id));
        c.setNombre(course.getNombre());
        c.setDescripcion(course.getDescripcion());
        cRepository.save(c);
        return mapper.toDto(c);
    }

}
