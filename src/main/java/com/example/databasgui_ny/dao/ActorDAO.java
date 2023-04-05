package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.ActorEntity;
import com.example.databasgui_ny.EntityMapping.FilmActorEntity;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class ActorDAO implements DAO<ActorEntity> {

    @Override
    public void create(ActorEntity actor) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(actor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<ActorEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<ActorEntity> query = session.createQuery("FROM ActorEntity ", ActorEntity.class);
        List<ActorEntity> actors = query.list();
        session.close();
        return actors;
    }

    @Override
    public ActorEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        ActorEntity actor = session.get(ActorEntity.class, id);
        session.close();
        return actor;
    }

    @Override
    public boolean update(ActorEntity actor) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(actor);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM FilmActorEntity fa WHERE fa.actorId = " + id);
        try {
            List<FilmActorEntity> filmActorEntityList = query.getResultList();
            for (FilmActorEntity filmActorEntity: filmActorEntityList) {
                session.remove(filmActorEntity);
            }
            Query quer2 = session.createQuery("FROM ActorEntity where actorId = " + id);
            ActorEntity actorEntity = (ActorEntity) quer2.uniqueResult();
            session.remove(actorEntity);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("An error occured while saving actor");
        } finally {
        session.getTransaction().commit();
        session.close();
        }

    }

    public void displayActors() {
        List<ActorEntity> actors = readAll();
        for (ActorEntity actor : actors) {
            System.out.println(actor.toString());
        }
    }

}
