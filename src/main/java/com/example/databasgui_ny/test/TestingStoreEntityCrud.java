package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.InventoryEntity;
import com.example.databasgui_ny.EntityMapping.StoreEntity;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import org.hibernate.query.Query;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class TestingStoreEntityCrud {


    @Test
    public void testingGetFromDataBase() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM StoreEntity where storeId = 1");
        StoreEntity storeEntity = (StoreEntity) query.uniqueResult();
        String actualString = storeEntity.getStoreId() + " " + storeEntity.getManagerStaffId() + " "
                + storeEntity.getAddressId() + " " + storeEntity.getLastUpdate();
        session.getTransaction().commit();
        session.close();
        String expectedString = "1 1 1 2006-02-15 04:57:12";
        System.out.println("Retrieving from database: " + actualString);
    }


    @Test
    public void testingAddToDataBase() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        StoreEntity newStore = new StoreEntity();
        newStore.setStoreId(3);
        newStore.setManagerStaffId(3);
        newStore.setAddressId(3);
        newStore.setLastUpdate(new java.sql.Timestamp(System.currentTimeMillis()));
        session.save(newStore);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added store with id: " + newStore.getStoreId());
    }


    @Test
    public void testingRemoveFromStoreDataBase() {
        int idToRemove = 2;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM InventoryEntity i WHERE i.storeId = " + idToRemove);
        Query query2 = session.createQuery("FROM StaffEntity i WHERE i.storeId = " + idToRemove);
        Query query3 = session.createQuery("FROM StoreEntity s WHERE s.storeId = " + idToRemove);
        List<InventoryEntity> inventoryEntityList = query.list();
        StoreEntity storeEntity = (StoreEntity) query3.uniqueResult();
        for (InventoryEntity inventoryEntity : inventoryEntityList) {
            session.delete(inventoryEntity);



        }
        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void testingUpdateStoreDataBase() {
        int idToUpdate = 2;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM StoreEntity where storeId = " + idToUpdate);
        StoreEntity storeEntity = (StoreEntity) query.uniqueResult();
        storeEntity.setManagerStaffId(2);
        session.update(storeEntity);
        session.getTransaction().commit();
        session.close();
        System.out.println("Updated store with id: " + storeEntity.getStoreId());
    }


}




//
//    @Test
//    public void testUpdateInDataBase() {
//        //Create a test that updates a store in the database
//        //Hint: You need to update the store in the film_actor table first
//        //Hint: You need to update the store in the inventory table first
//        int idToUpdate = 2;
//        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("FROM StoreEntity where storeId = " + idToUpdate);
//        StoreEntity storeEntity = (StoreEntity) query.uniqueResult();
//        storeEntity.setManagerStaffId(2);
//        session.update(storeEntity);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("Updated store with id: " + storeEntity.getStoreId());
//    }
//
//
//

