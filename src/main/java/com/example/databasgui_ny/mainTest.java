package com.example.databasgui_ny;

import com.example.databasgui_ny.entities.Actor;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class mainTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Actor actor = session.get(Actor.class, 1);

        List<Actor> actorList = session.createQuery("FROM Actor").list();
        System.out.println(actorList.size());

        System.out.println(actor.getFirst_name());
        session.getTransaction().commit();
        session.close();


    }
}
