//package com.example.databasgui_ny.dao;
//
//import com.example.databasgui_ny.entities.Actor;
//import com.example.databasgui_ny.repositories.DAO;
//import com.example.databasgui_ny.util.SessionFactorySingleton;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//
//import java.util.List;
//
//public class AddressDAO implements DAO<Address> {
//
//
//
//        @Override
//        public void create(Address address) {
//            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.save(address);
//            session.getTransaction().commit();
//            session.close();
//        }
//
//        @Override
//        public List<Address> readAll() {
//            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//            Query<Actor> query = session.createQuery("FROM Address", Address.class);
//            List<Actor> actors = query.list();
//            session.close();
//            return adress;
//        }
//
//        @Override
//        public Address read(int id) {
//            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            Address address = session.get(Address.class, id);
//            session.close();
//            return address;
//        }
//
//        @Override
//        public boolean update(Address address) {
//            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.getTransaction().begin();
//            session.update(address);
//            session.getTransaction().commit();
//            session.close();
//
//            return true;
//        }
//
//        @Override
//        public void delete(int id) {
//            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.getTransaction().begin();
//            Actor actor = session.get(Actor.class, id);
//            if (actor != null) {
//                session.delete(actor);
//            }
//            session.getTransaction().commit();
//            session.close();
//        }
//
//        public void displayActors() {
//            List<Address> address = readAll();
//            for (Address address : address) {
//                System.out.println(actor.toString());
//            }
//        }
//
//    }
//
//
