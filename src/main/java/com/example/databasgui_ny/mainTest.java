package com.example.databasgui_ny;

import com.example.databasgui_ny.dao.ActorDAO;
import com.example.databasgui_ny.entities.Actor;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class mainTest {
    public static void main(String[] args) {
        ActorDAO actorDao = new ActorDAO();
        actorDao.displayActors();
//        List<Actor> actors = actorDao.readAll();
//        for (Actor actor : actors) {
//            System.out.println(actor.getFirst_name());
//        }
    }
}
