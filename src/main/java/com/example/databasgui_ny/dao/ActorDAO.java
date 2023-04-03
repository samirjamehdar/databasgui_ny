package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ActorDAO implements DAO<Actor> {

    @Override
    public void create(Actor actor) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(actor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Actor> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Actor> query = session.createQuery("FROM Actor", Actor.class);
        List<Actor> actors = query.list();
        session.close();
        return actors;
    }

    @Override
    public Actor read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Actor actor = session.get(Actor.class, id);
        session.close();
        return actor;
    }

    @Override
    public boolean update(Actor actor) {
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
        session.getTransaction().begin();
        Actor actor = session.get(Actor.class, id);
        if (actor != null) {
            session.delete(actor);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayActors() {
        List<Actor> actors = readAll();
        for (Actor actor : actors) {
            System.out.println(actor.toString());
        }
    }

}
