package com.demo.alumnos.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "apellido", length = 45)
    private String apellido;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "dni")
    private Integer dni;



}
