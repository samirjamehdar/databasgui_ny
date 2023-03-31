package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Customer;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAO implements DAO<Customer> {
    @Override
    public void create(Customer customer) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Customer> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Customer> query = session.createQuery("FROM Customer ", Customer.class);
        List<Customer> customer = query.list();
        session.close();
        return customer;
    }

    @Override
    public Customer read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public boolean update(Customer customer) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(customer);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Customer customer = session.get(Customer.class, id);
        if (customer != null) {
            session.delete(customer);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayCustomer() {
        List<Customer> customerList = readAll();
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

}





