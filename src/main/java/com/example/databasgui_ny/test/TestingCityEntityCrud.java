package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.AddressEntity;
import com.example.databasgui_ny.EntityMapping.CityEntity;
import com.example.databasgui_ny.EntityMapping.CustomerEntity;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.sql.Timestamp;

public class TestingCityEntityCrud {
    @Test
    public void testGetCity() {
        int idToGet = 5;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM CityEntity ce WHERE ce.cityId = " + idToGet);
        CityEntity city = (CityEntity) query.getSingleResult();
        System.out.println(city.toString());

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void testCreateCity() {
        CityEntity newCity = new CityEntity("Pite", 90, new Timestamp(System.currentTimeMillis()));

        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newCity);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteCity() {
        int idToDelete = 10;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Query query = session.createQuery("FROM AddressEntity ae WHERE ae.city = " + idToDelete);
        AddressEntity address = (AddressEntity) query.getSingleResult();

        Query customerQuery = session.createQuery("FROM CustomerEntity ce where ce.address = " + address.getAddressId());
        CustomerEntity customer = (CustomerEntity) customerQuery.getSingleResult();
//        customer

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void testUpdateCity() {
        int idToUpdate = 20;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM CityEntity ce WHERE ce.cityId = " + idToUpdate);
        CityEntity city = (CityEntity) query.getSingleResult();
        city.setCity("updatedCityName");
        city.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        session.getTransaction().commit();
        session.close();
    }





}
