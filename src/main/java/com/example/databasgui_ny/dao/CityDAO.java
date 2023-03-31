package com.example.databasgui_ny.dao;


import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.example.databasgui_ny.entities.City;
import java.util.List;

public class CityDAO implements DAO<City> {
    @Override
    public void create(City city) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<City> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<City> query = session.createQuery("FROM City", City.class);
        List<City> city = query.list();
        session.close();
        return city;
    }

    @Override
    public City read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        City city = session.get(City.class, id);
        session.close();
        return city;
    }

    @Override
    public boolean update(City city) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(city);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        City city = session.get(City.class, id);
        if (city != null) {
            session.delete(city);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayCity() {
        List<City> cityList = readAll();
        for (City city : cityList) {
            System.out.println(city.toString());
        }
    }

}


