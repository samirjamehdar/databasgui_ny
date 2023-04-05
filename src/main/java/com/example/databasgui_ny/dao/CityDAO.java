package com.example.databasgui_ny.dao;


import com.example.databasgui_ny.EntityMapping.CityEntity;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.example.databasgui_ny.entities.City;
import java.util.List;

public class CityDAO implements DAO<CityEntity> {
    @Override
    public void create(CityEntity city) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<CityEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<CityEntity> query = session.createQuery("FROM CityEntity ", CityEntity.class);
        List<CityEntity> city = query.list();
        session.close();
        return city;
    }

    @Override
    public CityEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        CityEntity city = session.get(CityEntity.class, id);
        session.close();
        return city;
    }

    @Override
    public boolean update(CityEntity city) {
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
        List<CityEntity> cityList = readAll();
        for (CityEntity city : cityList) {
            System.out.println(city.toString());
        }
    }

}


