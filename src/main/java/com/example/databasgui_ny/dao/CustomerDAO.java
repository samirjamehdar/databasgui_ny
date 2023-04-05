package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.CustomerEntity;
import com.example.databasgui_ny.EntityMapping.PaymentEntity;
import com.example.databasgui_ny.EntityMapping.RentalEntity;
import com.example.databasgui_ny.entities.Customer;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAO implements DAO<CustomerEntity> {
    @Override
    public void create(CustomerEntity customer) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<CustomerEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<CustomerEntity> query = session.createQuery("FROM CustomerEntity ", CustomerEntity.class);
        List<CustomerEntity> customer = query.list();
        session.close();
        return customer;
    }

    @Override
    public CustomerEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        CustomerEntity customer = session.get(CustomerEntity.class, id);
        session.close();
        return customer;
    }

    @Override
    public boolean update(CustomerEntity customer) {
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
        session.beginTransaction();
        try {
            // Tar först bort alla instanser av customer i Payment
            Query paymentQuery = session.createQuery("FROM PaymentEntity pe WHERE pe.customerId = " + id);
            List<PaymentEntity> paymentList = paymentQuery.getResultList();
            for (PaymentEntity payment: paymentList) {
                session.remove(payment);
            }
            // Tar sedan bort alla instanser av customer i Rental
            Query rentalQuery = session.createQuery("FROM RentalEntity re WHERE re.customerId = " + id);
            List<RentalEntity> rentalList = rentalQuery.getResultList();
            for (RentalEntity rental: rentalList) {
                session.remove(rental);
            }
            // Kan sedan ta bort den angivna customern
            Query customerQuery = session.createQuery("FROM CustomerEntity ce WHERE ce.customerId = " + id);
            CustomerEntity customer = (CustomerEntity) customerQuery.getSingleResult();
            session.remove(customer);
        } catch (jakarta.persistence.NoResultException e) {
            System.out.println("The customer does not exist in the database");
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public void displayCustomer() {
        List<CustomerEntity> customerList = readAll();
        for (CustomerEntity customer : customerList) {
            System.out.println(customer.toString());
        }
    }

}





