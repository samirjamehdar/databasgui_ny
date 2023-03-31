package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Payment;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentDAO implements DAO<Payment> {

    @Override
    public void create(Payment payment) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(payment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Payment> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Payment> query = session.createQuery("FROM Payment", Payment.class);
        List<Payment> paymentList = query.list();
        session.close();
        return paymentList;
    }

    @Override
    public Payment read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Payment payment = session.get(Payment.class, id);
        session.close();
        return payment;
    }

    @Override
    public boolean update(Payment payment) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(payment);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Payment payment = session.get(Payment.class, id);
        if (payment != null) {
            session.delete(payment);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayPayments() {
        List<Payment> paymentList = readAll();
        for (Payment payment : paymentList) {
            System.out.println(payment.toString());
        }
    }

}
