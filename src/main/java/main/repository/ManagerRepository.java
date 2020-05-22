package main.repository;

import main.entity.Plane;
import main.entity.PlaneSchedule;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
     * Metoda ce adauga un nou zbor in baza de date
     * @param flight
     * @return
     */
    public String addFlight(PlaneSchedule flight){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(flight);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Flight added";
    }



}
