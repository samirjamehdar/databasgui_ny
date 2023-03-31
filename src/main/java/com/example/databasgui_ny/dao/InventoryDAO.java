package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Inventory;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class InventoryDAO implements DAO<Inventory> {

    @Override
    public void create(Inventory inventory) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(inventory);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Inventory> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Inventory> query = session.createQuery("FROM Inventory", Inventory.class);
        List<Inventory> inventoryList = query.list();
        session.close();
        return inventoryList;
    }

    @Override
    public Inventory read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Inventory inventory = session.get(Inventory.class, id);
        session.close();
        return inventory;
    }

    @Override
    public boolean update(Inventory inventory) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(inventory);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Inventory inventory = session.get(Inventory.class, id);
        if (inventory != null) {
            session.delete(inventory);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayInvetories() {
        List<Inventory> inventoryList = readAll();
        for (Inventory inventory : inventoryList) {
            System.out.println(inventory.toString());
        }
    }

}
