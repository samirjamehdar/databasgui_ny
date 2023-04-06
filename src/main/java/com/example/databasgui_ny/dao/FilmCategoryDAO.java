package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.FilmCategoryEntity;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmCategoryDAO implements DAO<FilmCategoryEntity> {
    @Override
    public void create(FilmCategoryEntity filmCategory) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(filmCategory);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<FilmCategoryEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<FilmCategoryEntity> query = session.createQuery("FROM FilmCategoryEntity ", FilmCategoryEntity.class);
        List<FilmCategoryEntity> filmCategory = query.list();
        session.close();
        return filmCategory;
    }

    @Override
    public FilmCategoryEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        FilmCategoryEntity filmCategory = session.get(FilmCategoryEntity.class, id);
        session.close();
        return filmCategory;
    }

    @Override
    public boolean update(FilmCategoryEntity filmCategory) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(filmCategory);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public void delete(int filmId) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("FROM FilmCategoryEntity fce WHERE fce.filmId = " + filmId);
        FilmCategoryEntity filmCategory = (FilmCategoryEntity) query.getSingleResult();
        session.remove(filmCategory);
        session.getTransaction().commit();
        session.close();
    }

    public void displayFilmCategory() {
        List<FilmCategoryEntity> filmCategoryList = readAll();
        for (FilmCategoryEntity filmCategory : filmCategoryList) {
            System.out.println(filmCategory.toString());
        }
    }

}







