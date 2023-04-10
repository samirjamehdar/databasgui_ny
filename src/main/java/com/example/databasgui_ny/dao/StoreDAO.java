package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.StoreEntity;
import com.example.databasgui_ny.entities.Store;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StoreDAO implements DAO<StoreEntity> {

    @Override
    public void create(StoreEntity store) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(store);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<StoreEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<StoreEntity> query = session.createQuery("FROM StoreEntity", StoreEntity.class);
        List<StoreEntity> storeList = query.list();
        session.close();
        return storeList;
    }

    @Override
    public StoreEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        StoreEntity store = session.get(StoreEntity.class, id);
        session.close();
        return store;
    }

    @Override
    public boolean update(StoreEntity store) {
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
        StoreEntity store = session.get(StoreEntity.class, id);
        if (store != null) {
            session.delete(store);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayStores() {
        List<StoreEntity> storeList = readAll();
        for (StoreEntity store : storeList) {
            System.out.println(store.toString());
        }
    }

}
