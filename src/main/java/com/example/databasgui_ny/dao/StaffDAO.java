package com.example.databasgui_ny.dao;

import com.example.databasgui_ny.EntityMapping.StaffEntity;
import com.example.databasgui_ny.entities.Actor;
import com.example.databasgui_ny.entities.Staff;
import com.example.databasgui_ny.repositories.DAO;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StaffDAO implements DAO<StaffEntity> {

    @Override
    public void create(StaffEntity staff) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(staff);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<StaffEntity> readAll() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<StaffEntity> query = session.createQuery("FROM StaffEntity", StaffEntity.class);
        List<StaffEntity> staffList = query.list();
        session.close();
        return staffList;
    }

    @Override
    public StaffEntity read(int id) {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        StaffEntity staff = session.get(StaffEntity.class, id);
        session.close();
        return staff;
    }

    @Override
    public boolean update(StaffEntity staff) {
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
        List<StaffEntity> staffList = readAll();
        for (StaffEntity staff : staffList) {
            System.out.println(staff.toString());
        }
    }

}
