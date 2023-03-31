package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.FilmText;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmTextDAO implements DAO<FilmText> {

    @Override
    public void create(FilmText filmText) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(filmText);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<FilmText> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<FilmText> query = session.createQuery("FROM FilmText", FilmText.class);
        List<FilmText> filmTextList = query.list();
        session.close();
        return filmTextList;
    }

    @Override
    public FilmText read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        FilmText filmText = session.get(FilmText.class, id);
        session.close();
        return filmText;
    }

    @Override
    public boolean update(FilmText filmText) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(filmText);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        FilmText filmText = session.get(FilmText.class, id);
        if (filmText != null) {
            session.delete(filmText);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayFilmTexts() {
        List<FilmText> filmTextList = readAll();
        for (FilmText filmText : filmTextList) {
            System.out.println(filmText.toString());
        }
    }

}
