package repository;

import entity.Plane;
import entity.PlaneSchedule;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 *Clasa de repository ce realizeaza backendul operatiilor de realizate de un controller.
 */


public class ControllerRepository implements ControllerFacade{

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");

    /**
     * Metoda ce genereaza un raport in functie de tipul de fisier cerut.
     * @param type
     * @return
     */
    public String generateReport(String type){
        List<PlaneSchedule> schedule = getSchedule();
        if(schedule == null) {
            return "Couldn't get the schedule";
        }
        ReportFactory reportFactory= new ReportFactory();
        Report report = reportFactory.getReport(type);
        report.generateReport(schedule);
        return report.getClass().getSimpleName();
    }

    /**
     * Metoda ce returneaza din baza de date toate zborurile sub forma de lista.
     * @return
     */
    public List<PlaneSchedule> getSchedule(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<PlaneSchedule> schedule = entityManager.createQuery("SELECT a FROM  PlaneSchedule a", PlaneSchedule.class).getResultList();
        return schedule;
    }

    /**
     * Metoda cauta un anumit zbor si ii updateaza statusul in caz ca acesta se afla in baza de date
     * @param code
     * @param status
     * @return
     */
    @Override
    public String updateFlightStatus(String code, String status) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        PlaneSchedule flight = entityManager.find(PlaneSchedule.class, code);
        entityManager.getTransaction().commit();
        if(flight == null){
            return "The specified flight was not found in the flisght schedule!";
        }
        flight.setStatus(status);
        entityManager.getTransaction().begin();
        entityManager.merge(flight);
        entityManager.getTransaction().commit();
        return "Flight status has been updated successfully";
    }

}
