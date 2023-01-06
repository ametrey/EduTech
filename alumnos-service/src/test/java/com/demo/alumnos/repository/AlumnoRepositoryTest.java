package com.demo.alumnos.repository;

import com.demo.alumnos.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@DataJpaTest
class AlumnoRepositoryTest  {
    @Autowired
    AlumnoRepository alumnoRepository;
}
