package com.demo.edutech.model;


import lombok.*;


import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int dni;

}
