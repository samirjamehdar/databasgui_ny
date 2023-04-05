package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.*;
import com.example.databasgui_ny.dao.FilmDAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import java.sql.Timestamp;
import java.util.List;

public class TestingFilmEntityCrud {
    @Test
    public void testGetFilm() {
        int idToGet = 10;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM FilmEntity fe WHERE fe.filmId = " + idToGet);
        FilmEntity film = (FilmEntity) query.getSingleResult();
        System.out.println(film.toString());
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public  void testDeleteFilm() {
        int idToDelete = 20;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query filmActorQuery = session.createQuery("FROM FilmActorEntity fae WHERE fae.filmId = " + idToDelete);
        List<FilmActorEntity> filmActorList = filmActorQuery.getResultList();
        for (FilmActorEntity filmActor: filmActorList) {
            session.remove(filmActor);
        }

        Query filmCategoryQuery = session.createQuery("FROM FilmCategoryEntity fce WHERE fce.filmId = " + idToDelete);
        FilmCategoryEntity filmCategory = (FilmCategoryEntity) filmCategoryQuery.getSingleResult();
        session.remove(filmCategory);

        Query inventoryQuery = session.createQuery("FROM InventoryEntity ie WHERE ie.filmId = " + idToDelete);
        List<InventoryEntity> inventoryList = inventoryQuery.getResultList();
        for (InventoryEntity inventory: inventoryList) {
            Query rentalQuery = session.createQuery("FROM RentalEntity re WHERE re.inventoryId = " + inventory.getInventoryId());
            List<RentalEntity> rentalList = rentalQuery.getResultList();
            for (RentalEntity rental: rentalList) {
                session.remove(rental);
            }
            session.remove(inventory);
        }

        Query filmQuery = session.createQuery("FROM FilmEntity fe WHERE fe.filmId = " + idToDelete);
        FilmEntity film = (FilmEntity) filmQuery.getSingleResult();
        session.remove(film);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testAddFilm() {
        int idToAdd = 20;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        FilmEntity film = new FilmEntity("PotatisFilm", "GOOD MOVIE", 2010, 13, 5, 5, new Timestamp(System.currentTimeMillis()));
        session.persist(film);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdateFilm() {
        int idToUpdate = 10;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM FilmEntity fe WHERE fe.filmId = " + idToUpdate);
        FilmEntity film = (FilmEntity) query.getSingleResult();
        film.setDescription("JAG HAR ÄNDRAT DENNA");
        session.persist(film);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDAODelete() {
        FilmDAO filmDAO = new FilmDAO();
        filmDAO.delete(4);
    }

}
