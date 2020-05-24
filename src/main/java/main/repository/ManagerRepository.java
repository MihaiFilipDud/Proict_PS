package main.repository;

import main.entity.Account;
import main.entity.Plane;
import main.entity.PlaneSchedule;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 *Clasa de main.repository ce realizeaza backendul operatiilor de realizate de un manager.
 */
@Component
public class ManagerRepository implements ManagerFacade{

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");


    /**
     * Metoda ce adauga un nou avion in baza de date.
     * @param plane
     * @return
     */
    public Plane addPlane(Plane plane){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(plane);
        entityManager.getTransaction().commit();
        entityManager.close();
        return plane;
    }


    /**
     * Adauga un zbor la baza de date
     * @param code
     * @param airport
     * @param destination
     * @param arrival
     * @param departure
     * @param status
     * @param plane
     * @return
     */
    public PlaneSchedule addFlight(String code, String airport, String destination, Date arrival, Date departure, String status, String plane){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Plane search = entityManager.find(Plane.class, plane);
        entityManager.getTransaction().commit();
        if(search == null){
            entityManager.close();
            System.out.println("No such plane");
            return null;
        }

        entityManager.getTransaction().begin();
        PlaneSchedule flight = new PlaneSchedule(code, airport, destination, arrival, departure, status, search);
        entityManager.merge(flight);
        entityManager.getTransaction().commit();
        entityManager.close();
        return flight;
    }

    /**
     * Returneaza toate avioanele din baza de date
     * @return
     */
    @Override
    public List<Plane> getPlanes() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Plane> planes = entityManager.createQuery("SELECT a FROM  Plane a", Plane.class).getResultList();
        return planes;
    }

    /**
     * Sterge un avion din baza de date
     * @param id
     * @return
     */
    @Override
    public String deletePlane(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Plane toFind = entityManager.find(Plane.class, id);
        if(toFind == null){
            entityManager.close();
            return "The plane does not exist!";
        }

        entityManager.remove(toFind);

        entityManager.getTransaction().commit();

        entityManager.close();

        return "The plane has been removed";
    }

    /**
     * Strege un zbor din baza de date
     * @param code
     * @return
     */
    @Override
    public String deleteFlight(String code) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        PlaneSchedule toFind = entityManager.find(PlaneSchedule.class, code);
        if(toFind == null){
            entityManager.close();
            return "The flight does not exist!";
        }

        entityManager.remove(toFind);

        entityManager.getTransaction().commit();

        entityManager.close();

        return "The flight has has been removed";
    }


}
