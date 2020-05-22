package main.repository;

import main.entity.Account;
import main.entity.Plane;
import main.entity.PlaneSchedule;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

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
    public String addPlane(Plane plane){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(plane);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Plane added";
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
    public String addFlight(String code, String airport, String destination, Date arrival, Date departure, String status, String plane){
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
        return "Flight added";
    }



}
