package com.example.databasgui_ny.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingleton {
    private static SessionFactory sessionFactory;
    private SessionFactorySingleton() {}
    public static SessionFactory getInstance() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
