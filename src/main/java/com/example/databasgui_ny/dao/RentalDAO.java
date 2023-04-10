package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.RentalEntity;
import com.example.databasgui_ny.entities.Rental;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RentalDAO implements DAO<RentalEntity> {

    @Override
    public void create(RentalEntity rental) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(rental);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<RentalEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<RentalEntity> query = session.createQuery("FROM RentalEntity", RentalEntity.class);
        List<RentalEntity> rentalList = query.list();
        session.close();
        return rentalList;
    }

    @Override
    public RentalEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        RentalEntity rental = session.get(RentalEntity.class, id);
        session.close();
        return rental;
    }

    @Override
    public boolean update(RentalEntity rental) {
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
        RentalEntity rental = session.get(RentalEntity.class, id);
        if (rental != null) {
            session.delete(rental);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayRentals() {
        List<RentalEntity> rentalList = readAll();
        for (RentalEntity rental : rentalList) {
            System.out.println(rental.toString());
        }
    }

}
