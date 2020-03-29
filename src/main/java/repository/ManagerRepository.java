package repository;

import entity.Plane;
import entity.PlaneSchedule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerRepository implements ManagerFacade{

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");

    public String addPlane(Plane plane){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(plane);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Plane added";
    }

    public String addFlight(PlaneSchedule flight){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(flight);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Flight added";
    }



}
