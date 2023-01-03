package com.demo.cursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursos.entities.Course;
import com.demo.cursos.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository cRepository;
    

    public List<Course> getAllCourses() {
        return cRepository.findAll();
    }


    public Optional<Course> getCourseById(Integer id) {
        return cRepository.findById(id);
    }
    
}
