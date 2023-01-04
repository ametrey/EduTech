package com.demo.cursos.exceptions;

public class Duplicated extends RuntimeException{

    public Duplicated() {
        super("Curso duplicado");
    }

}
