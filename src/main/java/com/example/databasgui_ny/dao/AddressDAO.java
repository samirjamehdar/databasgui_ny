package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.AddressEntity;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.example.databasgui_ny.entities.Address;
import java.util.List;

public class AddressDAO implements DAO<AddressEntity> {



        @Override
        public void create(AddressEntity address) {
            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
            session.close();
        }

        @Override
        public List<AddressEntity> readAll() {
            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query<AddressEntity> query = session.createQuery("FROM AddressEntity ", AddressEntity.class);
            List<AddressEntity> address = query.list();
            session.close();
            return address;
        }

        @Override
        public AddressEntity read(int id) {
            SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
            Session session = sessionFactory.openSession();
            AddressEntity address = session.get(AddressEntity.class, id);
            session.close();
            return address;
        }

        @Override
        public boolean update(AddressEntity address) {
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
            List<AddressEntity> addressList = readAll();
            for (AddressEntity address : addressList) {
                System.out.println(address.toString());
            }
        }

    }


