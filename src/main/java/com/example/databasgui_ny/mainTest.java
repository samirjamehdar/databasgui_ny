package com.example.databasgui_ny;

import com.example.databasgui_ny.dao.ActorDAO;
import com.example.databasgui_ny.dao.AddressDAO;
import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Address;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class mainTest {
    public static void main(String args[]) {
        ActorDAO actorDAO = new ActorDAO();
        Actor testActor = actorDAO.read(1);

        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(testActor);

        session.getTransaction().commit();
        session.close();

    }

}
