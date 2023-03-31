package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.example.databasgui_ny.entities.Address;
import java.util.List;

public class AddressDAO implements DAO<Address> {



        @Override
        public void create(Address address) {
            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
            session.close();
        }

        @Override
        public List<Address> readAll() {
            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query<Address> query = session.createQuery("FROM Address", Address.class);
            List<Address> address = query.list();
            session.close();
            return address;
        }

        @Override
        public Address read(int id) {
            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
            Session session = sessionFactory.openSession();
            Address address = session.get(Address.class, id);
            session.close();
            return address;
        }

        @Override
        public boolean update(Address address) {
            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.update(address);
            session.getTransaction().commit();
            session.close();

            return true;
        }

        @Override
        public void delete(int id) {
            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Address address = session.get(Address.class, id);
            if (address != null) {
                session.delete(address);
            }
            session.getTransaction().commit();
            session.close();
        }

        public void displayAddress() {
            List<Address> addressList = readAll();
            for (Address address : addressList) {
                System.out.println(address.toString());
            }
        }

    }


