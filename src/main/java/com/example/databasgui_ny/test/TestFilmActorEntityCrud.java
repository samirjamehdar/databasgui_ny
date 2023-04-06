package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.FilmActorEntity;
import com.example.databasgui_ny.dao.FilmActorDAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.util.List;

public class TestFilmActorEntityCrud {
    @Test
    public void testGetFilmActor() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM FilmActorEntity fae WHERE fae.actorId = " + 34);
        List<FilmActorEntity> filmactorList = query.getResultList();
        for (FilmActorEntity filmActor: filmactorList) {
            System.out.println(filmActor.getFilmId());
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteFilmActor() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM FilmActorEntity fae WHERE fae.actorId = " + 34);
        List<FilmActorEntity> filmactorList = query.getResultList();
        for (FilmActorEntity filmActor: filmactorList) {
            session.remove(filmActor);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testReadDao() {
        FilmActorDAO filmActorDAO = new FilmActorDAO();
        FilmActorEntity filmaActor = filmActorDAO.read(10);
        System.out.println(filmaActor.getActorId());
    }


}

