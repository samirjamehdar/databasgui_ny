package com.example.databasgui_ny;

import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Payment;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class mainTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        EntityManager entityManager = new Configuration().configure().createEntityManager();


        Payment payment = session.get(Payment.class, 5);  /** Här hämtar vi actor med ID 1 från databasen. */
//        System.out.println(actor.toString());
        System.out.println(payment.getPayment_id());
        session.getTransaction().commit();
        session.close();
    }
}
