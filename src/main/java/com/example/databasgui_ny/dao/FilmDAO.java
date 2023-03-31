package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Film;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmDAO implements DAO<Film> {
    @Override
    public void create(Film film) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(film);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Film> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Film> query = session.createQuery("FROM Film", Film.class);
        List<Film> film = query.list();
        session.close();
        return film;
    }

    @Override
    public Film read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Film film = session.get(Film.class, id);
        session.close();
        return film;
    }

    @Override
    public boolean update(Film film) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(film);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Film film = session.get(Film.class, id);
        if (film != null) {
            session.delete(film);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayFilm() {
        List<Film> filmList = readAll();
        for (Film film : filmList) {
            System.out.println(film.toString());
        }
    }

}




