package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.FilmTextEntity;
import com.example.databasgui_ny.entities.FilmText;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class TestFilmTextCrud {

    @Test
    public void testGetFilmText() {
        int idToGet = 65;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM FilmTextEntity fte WHERE fte.filmId = " + idToGet);
        FilmTextEntity filmText = (FilmTextEntity) query.getSingleResult();
        System.out.println(filmText.toString());
        session.getTransaction().commit();
        session.close();
    }

//    @Test
//    public void
}
