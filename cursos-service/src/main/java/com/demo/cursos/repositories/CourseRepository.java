package com.demo.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cursos.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
    
}
