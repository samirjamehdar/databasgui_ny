package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.FilmCategoryEntity;
import com.example.databasgui_ny.dao.FilmCategoryDAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.sql.Timestamp;

public class TestFilmCategoryCrud {
    @Test
    public void testGetFilmCategory() {
        int idToGet = 15;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM FilmCategoryEntity fce WHERE fce.filmId = " + idToGet);
        FilmCategoryEntity filmCategory = (FilmCategoryEntity) query.getSingleResult();
        System.out.println(filmCategory.getCategoryId());

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteFc() {
        int idToDelete = 15;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM FilmCategoryEntity fce WHERE fce.filmId = " + idToDelete);
        FilmCategoryEntity filmCategory = (FilmCategoryEntity) query.getSingleResult();
        session.remove(filmCategory);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDAOdelete() {
        FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAO();
        filmCategoryDAO.delete(26);
    }

    @Test
    public void testCreateUpdateFC() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        FilmCategoryEntity filmCategory = new FilmCategoryEntity(1001, 4, new Timestamp(System.currentTimeMillis()));
        session.persist(filmCategory);

        session.getTransaction().commit();
        session.close();

    }
}
