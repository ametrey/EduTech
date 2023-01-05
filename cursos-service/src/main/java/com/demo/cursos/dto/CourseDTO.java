package com.demo.cursos.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto implements Serializable {

    private Integer cursoId;
    private String nombre;
    private String descripcion;

    // private String nombreProfesor;
    // private List<String> nombres alumnos;

}
