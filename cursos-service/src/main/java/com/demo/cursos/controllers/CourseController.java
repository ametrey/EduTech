package com.demo.cursos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cursos.dto.CourseCreationDto;
import com.demo.cursos.dto.CourseDto;
import com.demo.cursos.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping()
    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        return new ResponseEntity<>(courseService.getCourseDtoById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createCourse(@Valid @RequestBody CourseCreationDto dto) {
        courseService.createCourse(dto);
        return new ResponseEntity<>("Curso creado correctamente", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody CourseDto course) {
        courseService.updateCourse(id, course);
        return new ResponseEntity<>("Curso modificado correctamente", HttpStatus.ACCEPTED);
    }

}
