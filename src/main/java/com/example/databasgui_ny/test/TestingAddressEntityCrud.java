package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.AddressEntity;
import com.example.databasgui_ny.EntityMapping.CityEntity;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import java.sql.Timestamp;

import static junit.framework.Assert.*;

public class TestingAddressEntityCrud {
    /** För att ta bort en address måste den customer som är kopplad till addressen tas bort, och då tas automatiskt
     * addressen bort
     * **/
    @Test
    public void testGetFromDatabase() {
        int idToGet = 1;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM AddressEntity WHERE addressId = " + idToGet);
        AddressEntity addressEntity = (AddressEntity) query.getSingleResult();
        System.out.println(addressEntity.toString());
        session.getTransaction().commit();
        session.close();
        assertTrue(true);
    }

    @Test
    public void testAddingAddress() {
        CityEntity newCity = new CityEntity("PotatisGatan", 90, new Timestamp(System.currentTimeMillis()));
        AddressEntity newAddress = new AddressEntity("Potatisgatan 31", null, "Norrbotten", newCity,
                "941potatoe", "0767780424", new Timestamp(System.currentTimeMillis()));

        System.out.println(newAddress.getLocation());
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newAddress);
        session.getTransaction().commit();
        session.close();
    }

}
