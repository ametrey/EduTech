package com.demo.cursos.dto;

import org.springframework.stereotype.Component;

import com.demo.cursos.entities.Course;

@Component
public class Mapper {

    public CourseDto toDto(Course c) {
        return new CourseDto(c.getCursoId(), c.getNombre(), c.getDescripcion());
    }

    public Course toCourse(CourseCreationDto cDto) {
        return new Course(cDto.getNombre(), cDto.getDescripcion());
    }

    public Course toCourse(CourseDto cDto) {
        return new Course(cDto.getNombre(), cDto.getDescripcion());
    }
}