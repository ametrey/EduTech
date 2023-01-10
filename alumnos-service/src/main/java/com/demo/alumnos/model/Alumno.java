package com.demo.alumnos.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "coursealumno",
            joinColumns = @JoinColumn(name = "alumnoid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "courseid", referencedColumnName = "id"))
    private List<Course> courses;


}
