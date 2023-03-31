package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Rental;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RentalDAO implements DAO<Rental> {

    @Override
    public void create(Rental rental) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(rental);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Rental> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Rental> query = session.createQuery("FROM Rental", Rental.class);
        List<Rental> rentalList = query.list();
        session.close();
        return rentalList;
    }

    @Override
    public Rental read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Rental rental = session.get(Rental.class, id);
        session.close();
        return rental;
    }

    @Override
    public boolean update(Rental rental) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(rental);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Rental rental = session.get(Rental.class, id);
        if (rental != null) {
            session.delete(rental);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayRentals() {
        List<Rental> rentalList = readAll();
        for (Rental rental : rentalList) {
            System.out.println(rental.toString());
        }
    }

}
