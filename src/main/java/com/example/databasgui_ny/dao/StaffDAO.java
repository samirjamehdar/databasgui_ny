package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Staff;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StaffDAO implements DAO<Staff> {

    @Override
    public void create(Staff staff) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(staff);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Staff> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Staff> query = session.createQuery("FROM Staff", Staff.class);
        List<Staff> staffList = query.list();
        session.close();
        return staffList;
    }

    @Override
    public Staff read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        Staff staff = session.get(Staff.class, id);
        session.close();
        return staff;
    }

    @Override
    public boolean update(Staff staff) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(staff);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Staff staff = session.get(Staff.class, id);
        if (staff != null) {
            session.delete(staff);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void displayStaffs() {
        List<Staff> staffList = readAll();
        for (Staff staff : staffList) {
            System.out.println(staff.toString());
        }
    }

}
