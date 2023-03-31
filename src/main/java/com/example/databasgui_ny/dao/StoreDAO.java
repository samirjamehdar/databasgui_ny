package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Store;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StoreDAO implements DAO<Store> {

    @Override
    public void create(Store store) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(store);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Store> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Store> query = session.createQuery("FROM Store", Store.class);
        List<Store> storeList = query.list();
        session.close();
        return storeList;
    }

    @Override
    public Store read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Store store = session.get(Store.class, id);
        session.close();
        return store;
    }

    @Override
    public boolean update(Store store) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(store);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Store store = session.get(Store.class, id);
        if (store != null) {
            session.delete(store);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayStores() {
        List<Store> storeList = readAll();
        for (Store store : storeList) {
            System.out.println(store.toString());
        }
    }

}
