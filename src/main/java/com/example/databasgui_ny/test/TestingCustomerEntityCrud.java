package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.*;
import com.example.databasgui_ny.dao.CustomerDAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import java.sql.Timestamp;
import java.util.List;

import static junit.framework.Assert.*;

public class TestingCustomerEntityCrud {

    @Test
    public void testGetCustomer() {
        int idToGet = 5;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM CustomerEntity ce WHERE ce.id = " + idToGet);
        CustomerEntity customerEntity = (CustomerEntity) query.getSingleResult();

        customerEntity.getFirstName();
        System.out.println(customerEntity.getFirstName());
        session.getTransaction().commit();
        session.close();
        assertEquals("Customer name", customerEntity.getFirstName(), "ELIZABETH");
    }

    @Test
    public void deleteCustomer() {
        int idToDelete = 10;
        System.out.println("Customer to be deleted, id: " + idToDelete);
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM CustomerEntity ce WHERE ce.id = " + idToDelete);
        CustomerEntity customerEntity = (CustomerEntity) query.getSingleResult();

        // Måste först ta bort alla instanser av customern i payment
        Query paymentQuery = session.createQuery("FROM PaymentEntity pe WHERE pe.customerId = " + idToDelete);
        List<PaymentEntity> paymentList = paymentQuery.getResultList();
        for (PaymentEntity payment: paymentList) {
            session.remove(payment);
        }
        // Måste sedan ta bort alla instanser av customern i rental
        Query rentalQuery = session.createQuery("FROM RentalEntity re WHERE re.customerId = " + idToDelete);
        List<RentalEntity> rentalList = rentalQuery.getResultList();
        for (RentalEntity rental: rentalList) {
            session.remove(rental);
        }

        session.remove(customerEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdateCustomer() {
        int idToUpdate = 20;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM CustomerEntity ce WHERE ce.customerId = " + idToUpdate);
        CustomerEntity customer = (CustomerEntity) query.getSingleResult();
        customer.setFirstName("updatedFirstName");
        customer.setLastName("updatedLastName");
        customer.setEmail("update@gmail.com");
        customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testCreateCustomer() {
        CityEntity city = new CityEntity("Piteå", 90, new Timestamp(System.currentTimeMillis()));
        AddressEntity address = new AddressEntity("Björkgatan 31", null, "Norrbotten", city,
                "94136", "0767780434", new Timestamp(System.currentTimeMillis()));

        CustomerEntity newCustomer = new CustomerEntity("Samir", "Jamehdar", "samir@hotmail.com", address, (byte) 1, 1, new Timestamp(System.currentTimeMillis()));

        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(newCustomer);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteDAO() {
        // address 6 borde gå bort om customer 2 tas bort
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.delete(52);
    }
}
