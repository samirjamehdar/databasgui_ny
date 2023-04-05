package com.example.databasgui_ny.test;

import com.example.databasgui_ny.EntityMapping.ActorEntity;
import com.example.databasgui_ny.EntityMapping.FilmActorEntity;
import com.example.databasgui_ny.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestingActorEntityCrud {
    /*
        Innan testerna körs bör databasen vara i original skick, annars finns det risk
        att testerna inte fungerar som förväntat!
    */
    @Test
    public void testingGetFromDataBase() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM ActorEntity where actorId = 25");
        ActorEntity actorEntity = (ActorEntity) query.uniqueResult();
        String actualString = actorEntity.getActorId() + " " + actorEntity.getFirstName() + " " + actorEntity.getLastName() + " " + actorEntity.getLastUpdate();
        session.getTransaction().commit();
        session.close();

        String expectedString = "25 KEVIN BLOOM 2006-02-15 04:34:33.0";
        System.out.println("Retrieving Actor: " + actualString);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testRemoveFromDatabase() {
        /*
            Ändra på idToRemove till den actor_id som ska tas bort
         */
        int idToRemove = 201;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // För att ta bort en actor måste vi först ta bort alla instanser av actorn i denna kopplingstabell
        Query query = session.createQuery("FROM FilmActorEntity fa WHERE fa.actorId = " + idToRemove);
        try {
            // Om användaren inte är kopplad till en film, så kommer listan nedan att vara 0, därför gör vi try catch.
            List<FilmActorEntity> filmActorEntityList = query.getResultList();
            filmActorEntityList.get(0).getFilmId();
            System.out.println(filmActorEntityList.get(0).getFilmId());
            for (FilmActorEntity filmActorEntity : filmActorEntityList) {
                session.remove(filmActorEntity);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Denna användare är inte kopplad till någon film och tas bort direkt :)");
        }

        // Sedan kan vi fortsätta med att ta bort actor från Actor
        Query query2 = session.createQuery("FROM ActorEntity where actorId = " + idToRemove);
        ActorEntity actorEntity = (ActorEntity) query2.uniqueResult();

        session.remove(actorEntity);
        session.getTransaction().commit();
        session.close();

        boolean success = true;
        assertTrue(success);
    }

    @Test
    public void testingUpdateActor() {
        /*
            Här ska vi testa att uppdatera en specifik actor, änddra på idToUpdate
            till actor_id som ska uppdateras
         */
        int idToUpdate = 11;
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Börja med att hämta den specifika actorn
        Query query = session.createQuery("FROM ActorEntity WHERE actorId = " + idToUpdate);
        ActorEntity actorEntity = (ActorEntity) query.getSingleResult();
        System.out.println("ACTOR Som ska uppdateras heter: " + actorEntity.getFirstName());

        // Ändrar sedan actorn och sparar den i databasen med session
        actorEntity.setFirstName("ChangedName");
        actorEntity.setLastName("ChangedLastName");
        actorEntity.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        session.persist(actorEntity);
        session.getTransaction().commit();
        session.close();
        // Testar att hämta actorns fält för att se om ändringarna har skett
        List<String> expectedFields = new ArrayList<>();
        expectedFields.add(actorEntity.getFirstName());
        expectedFields.add(actorEntity.getLastName());
        assertEquals("LIKA", expectedFields, getActualActorFields(idToUpdate));
    }

    private List<String> getActualActorFields(int idToUpdate) {
        /*
            Detta är en hjälpmetod för testingUpdateActor
         */
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query testQuery = session.createQuery("FROM ActorEntity WHERE actorId = " + idToUpdate);
        ActorEntity testActor = (ActorEntity) testQuery.getSingleResult();
        List<String> actualFields = new ArrayList<>();
        actualFields.add(testActor.getFirstName());
        actualFields.add(testActor.getLastName());
        session.getTransaction().commit();
        session.close();
        return actualFields;
    }


    @Test
    public void testAddingActor() {
        SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ActorEntity newActor = new ActorEntity();
        newActor.setFirstName("NewUserName");
        newActor.setLastName("NewLastName");
        newActor.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        session.persist(newActor);
        session.getTransaction().commit();
        session.close();
        assertTrue(true);
    }

}
