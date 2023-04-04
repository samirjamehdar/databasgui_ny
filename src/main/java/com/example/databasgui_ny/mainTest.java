package com.example.databasgui_ny;

import com.example.databasgui_ny.dao.ActorDAO;
import com.example.databasgui_ny.dao.AddressDAO;
import com.example.databasgui_ny.dao.InventoryDAO;
import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Address;
import com.example.databasgui_ny.entities.Inventory;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class mainTest {
    public static void main(String args[]) {
        AddressDAO addressDAO = new AddressDAO();

        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Address address = addressDAO.read(20);
        System.out.println(address.getCity());
        session.close();
    }
}
