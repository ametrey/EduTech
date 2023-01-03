package com.demo.edutech.dao;

import com.demo.edutech.model.Profesor;

import java.util.List;

public interface ProfesorDAO {

    public List<Profesor> findAll();

    public Profesor findById(int id);

    public void save(Profesor profesor);

    public void deleteById(int id);
}
