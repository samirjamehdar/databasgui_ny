//package com.example.databasgui_ny.dao;
//
//import com.example.databasgui_ny.util.SessionFactorySingleton;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//
//import java.util.List;
//
//
//public class FilmActorDAO implements DAO<FilmActor> {
//    @Override
//    public void create(FilmActor filmActor) {
//        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(filmActor);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public List<FilmActor> readAll() {
//        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Query<FilmActor> query = session.createQuery("FROM FilmActor ", FilmActor.class);
//        List<FilmActor> filmActor = query.list();
//        session.close();
//        return filmActor;
//    }
//
//    @Override
//    public FilmActor read(int id) {
//        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        FilmActor filmActor = session.get(FilmActor.class, id);
//        session.close();
//        return filmActor;
//    }
//
//    @Override
//    public boolean update(FilmActor filmActor) {
//        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        session.update(filmActor);
//        session.getTransaction().commit();
//        session.close();
//
//        return true;
//    }
//
//    @Override
//    public void delete(int id) {
//        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        FilmActor filmActor = session.get(FilmActor.class, id);
//        if (filmActor != null) {
//            session.delete(filmActor);
//        }
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    public void displayFilmActor() {
//        List<FilmActor> filmActorList = readAll();
//        for (FilmActor filmActor : filmActorList) {
//            System.out.println(filmActor.toString());
//        }
//    }
//
//}
//
//
//
