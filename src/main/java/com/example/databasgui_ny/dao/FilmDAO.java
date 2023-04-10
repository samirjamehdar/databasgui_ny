package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.*;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import jakarta.persistence.Query;
import java.util.List;

public class FilmDAO implements DAO<FilmEntity> {
    @Override
    public void create(FilmEntity film) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(film);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<FilmEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM FilmEntity", FilmEntity.class);
        List<FilmEntity> film = query.getResultList();
        session.close();
        return film;
    }

    @Override
    public FilmEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        FilmEntity film = session.get(FilmEntity.class, id);
        session.close();
        return film;
    }

    @Override
    public boolean update(FilmEntity film) {
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
        session.beginTransaction();

        Query filmActorQuery = session.createQuery("FROM FilmActorEntity fae WHERE fae.filmId = " + id);
        List<FilmActorEntity> filmActorList = filmActorQuery.getResultList();
        for (FilmActorEntity filmActor: filmActorList) {
            session.remove(filmActor);
        }

        Query filmCategoryQuery = session.createQuery("FROM FilmCategoryEntity fce WHERE fce.filmId = " + id);
        FilmCategoryEntity filmCategory = (FilmCategoryEntity) filmCategoryQuery.getSingleResult();
        session.remove(filmCategory);

        Query inventoryQuery = session.createQuery("FROM InventoryEntity ie WHERE ie.filmId = " + id);
        List<InventoryEntity> inventoryList = inventoryQuery.getResultList();
        for (InventoryEntity inventory: inventoryList) {
            Query rentalQuery = session.createQuery("FROM RentalEntity re WHERE re.inventoryId = " + inventory.getInventoryId());
            List<RentalEntity> rentalList = rentalQuery.getResultList();
            for (RentalEntity rental: rentalList) {
                session.remove(rental);
            }
            session.remove(inventory);
        }

        Query filmQuery = session.createQuery("FROM FilmEntity fe WHERE fe.filmId = " + id);
        FilmEntity film = (FilmEntity) filmQuery.getSingleResult();
        session.remove(film);
        session.getTransaction().commit();
        session.close();
    }

    public void displayFilm() {
        List<FilmEntity> filmList = readAll();
        for (FilmEntity film : filmList) {
            System.out.println(film.toString());
        }
    }

}




