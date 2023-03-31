package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.FilmCategory;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmCategoryDAO implements DAO<FilmCategory> {
    @Override
    public void create(FilmCategory filmCategory) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(filmCategory);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<FilmCategory> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<FilmCategory> query = session.createQuery("FROM FilmCategory ", FilmCategory.class);
        List<FilmCategory> filmCategory = query.list();
        session.close();
        return filmCategory;
    }

    @Override
    public FilmCategory read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        FilmCategory filmCategory = session.get(FilmCategory.class, id);
        session.close();
        return new FilmCategory();
    }

    @Override
    public boolean update(FilmCategory filmCategory) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(filmCategory);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        FilmCategory filmCategory = session.get(FilmCategory.class, id);
        if (filmCategory != null) {
            session.delete(filmCategory);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayFilmCategory() {
        List<FilmCategory> filmCategoryList = readAll();
        for (FilmCategory filmCategory : filmCategoryList) {
            System.out.println(filmCategory.toString());
        }
    }

}







