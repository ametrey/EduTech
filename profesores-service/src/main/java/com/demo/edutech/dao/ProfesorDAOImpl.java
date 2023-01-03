package com.demo.edutech.dao;

import com.demo.edutech.model.Profesor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class ProfesorDAOImpl implements ProfesorDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Profesor> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Profesor> theQuery = currentSession.createQuery("from Profesor", Profesor.class);
        List<Profesor> profesores = theQuery.getResultList();
        return profesores;
    }

    @Override
    public Profesor findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Profesor profesor = currentSession.get(Profesor.class, id);
        return profesor;
    }

    @Override
    public void save(Profesor profesor) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(profesor);


    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Profesor> theQuery = currentSession.createQuery("delete from Profesor where id=:id");

        theQuery.setParameter("id", id);
        theQuery.executeUpdate();

    }
}
