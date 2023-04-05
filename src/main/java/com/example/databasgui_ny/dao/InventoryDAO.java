package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.InventoryEntity;
import com.example.databasgui_ny.entities.Inventory;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class InventoryDAO implements DAO<InventoryEntity> {

    @Override
    public void create(InventoryEntity inventory) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(inventory);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<InventoryEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<InventoryEntity> query = session.createQuery("FROM InventoryEntity ", InventoryEntity.class);
        List<InventoryEntity> inventoryList = query.list();
        session.close();
        return inventoryList;
    }

    @Override
    public InventoryEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        InventoryEntity inventory = session.get(InventoryEntity.class, id);
        session.close();
        return inventory;
    }

    @Override
    public boolean update(InventoryEntity inventory) {
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
        InventoryEntity inventory = session.get(InventoryEntity.class, id);
        if (inventory != null) {
            session.delete(inventory);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayInvetories() {
        List<InventoryEntity> inventoryList = readAll();
        for (InventoryEntity inventory : inventoryList) {
            System.out.println(inventory.toString());
        }
    }

}
