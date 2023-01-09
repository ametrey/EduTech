package com.demo.cursos.dto;

import org.springframework.stereotype.Component;

import com.demo.cursos.entities.Course;

@Component
public class Mapper {

    public CourseDTO toDto(Course c) {
        return new CourseDTO(c.getCursoId(), c.getNombre(), c.getDescripcion());
    }

    public Course toCourse(CourseCreationDTO cDto) {
        return new Course(cDto.getNombre(), cDto.getDescripcion());
    }

    public Course toCourse(CourseDTO cDto) {
        return new Course(cDto.getNombre(), cDto.getDescripcion());
    }
}