package com.demo.edutech.service;

import com.demo.edutech.dao.ProfesorDAO;
import com.demo.edutech.model.Profesor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorImplService implements ProfesorService {

    private final ProfesorDAO profesorDAO;

    public ProfesorImplService(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    @Override
    public List<Profesor> findAll() {
        List<Profesor> listProfesores = profesorDAO.findAll();
        return listProfesores;
    }

    @Override
    public Profesor findById(int id) {
        Profesor profesor = profesorDAO.findById(id);
        return profesor;
    }

    @Override
    public void save(Profesor profesor) {
        profesorDAO.save(profesor);

    }

    @Override
    public void deleteById(int id) {
        profesorDAO.deleteById(id);
    }
}
