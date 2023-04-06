package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.FilmActorEntity;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;


public class FilmActorDAO implements DAO<FilmActorEntity> {
    @Override
    public void create(FilmActorEntity filmActor) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(filmActor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<FilmActorEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<FilmActorEntity> query = session.createQuery("FROM FilmActorEntity ", FilmActorEntity.class);
        List<FilmActorEntity> filmActor = query.list();
        session.close();
        return filmActor;
    }

    @Override
    public FilmActorEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM FilmActorEntity fae WHERE fae.filmId = " + id);
        FilmActorEntity filmActor = (FilmActorEntity) query.getSingleResult();
        session.close();
        return filmActor;
    }

    @Override
    public boolean update(FilmActorEntity filmActor) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(filmActor);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public void delete(int filmId) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("FROM FilmActorEntity fae WHERE fae.filmId = " + filmId);
        List<FilmActorEntity> filmactorList = query.getResultList();
        for (FilmActorEntity filmActor: filmactorList) {
            session.remove(filmActor);
        }

        session.getTransaction().commit();
        session.close();
    }

    public void deleteActor(int actorId) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM FilmActorEntity fae WHERE fae.actorId = " + actorId);
        List<FilmActorEntity> filmActorList = query.getResultList();
        for (FilmActorEntity filmActor: filmActorList) {
            session.remove(filmActor);
        }
        session.getTransaction().commit();
        session.close();
    }


    public void displayFilmActor() {
        List<FilmActorEntity> filmActorList = readAll();
        for (FilmActorEntity filmActor : filmActorList) {
            System.out.println(filmActor.toString());
        }
    }

}



