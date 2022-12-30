package com.demo.alumnos.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Data
@Getter
@Setter
public class AlumnoDto {

    private Long id;

    private String apellido;

    private String nombre;

    private Integer dni;

}
