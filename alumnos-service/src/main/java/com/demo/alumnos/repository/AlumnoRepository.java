package com.demo.alumnos.repository;

import com.demo.alumnos.dto.AlumnoDto;
import com.demo.alumnos.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
