package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.PaymentEntity;
import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Payment;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentDAO implements DAO<PaymentEntity> {

    @Override
    public void create(PaymentEntity payment) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(payment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<PaymentEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<PaymentEntity> query = session.createQuery("FROM PaymentEntity", PaymentEntity.class);
        List<PaymentEntity> paymentList = query.list();
        session.close();
        return paymentList;
    }

    @Override
    public PaymentEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        PaymentEntity payment = session.get(PaymentEntity.class, id);
        session.close();
        return payment;
    }

    @Override
    public boolean update(PaymentEntity payment) {
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
        PaymentEntity payment = session.get(PaymentEntity.class, id);
        if (payment != null) {
            session.remove(payment);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayPayments() {
        List<PaymentEntity> paymentList = readAll();
        for (PaymentEntity payment : paymentList) {
            System.out.println(payment.toString());
        }
    }

}
