package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.CategoryEntity;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import static junit.framework.Assert.*;

public class TestingCategoryEntityCrud {
    @Test
    public void testGetCategory() {
        int idToGet = 1;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM CategoryEntity ce WHERE ce.categoryId = " + idToGet);
        CategoryEntity categoryEntity = (CategoryEntity) query.getSingleResult();
        System.out.println(categoryEntity.getName());
        session.getTransaction().commit();
        session.close();
        String expectedName = "Action";
        assertEquals("Category name", expectedName, categoryEntity.getName());
    }

    @Test
    public void testRemoveFromDatabase() {
        int idToRemove = 2;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query  = session.createQuery("FROM CategoryEntity ce WHERE ce.categoryId = " + idToRemove);
        CategoryEntity categoryEntity = (CategoryEntity) query.getSingleResult();
        session.remove(categoryEntity);
        session.getTransaction().commit();
        session.close();
    }
}
