package com.demo.cursos.exceptions;

public class NotFound extends RuntimeException {

    public NotFound(Integer id) {
        super("No se encontró un curso con el id: " + id);
    }

    public NotFound(String message) {
        super();
    }

}
