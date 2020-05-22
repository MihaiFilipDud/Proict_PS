package main.business;

import main.entity.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import main.repository.ManagerFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Clasa se ocupa de de operatiile realizate de un contrlor de trafic
 */

@RestController
public class ManagerService implements UserService{

    private ManagerFacade manager = ManagerFacade.getManagerRepository();
    private List<ATManager> managers = new ArrayList<>();

    public ManagerService(){};

    public ManagerService(ManagerFacade manager){
        this.manager = manager;
    }

    /**
     * Metoda corespunzatoare endpointului ce adauga un plane in tabela corespunzatoare
     * @param id
     * @param model
     * @param company
     * @return
     */

    @PostMapping("/addPlane") //localhost:8080/addPlane
    @CrossOrigin(origins = "*")
    public Plane addPlane(String id, String model, String company){
        Plane plane = new Plane(id, model, company);
        System.out.println(manager.addPlane(plane));
        return plane;
    }

    /**
     * Metoda corespunzatoare endpointului ce adauga un flight in tabela corespunzatoare
     * @param code
     * @param airport
     * @param destination
     * @param arrival
     * @param departure
     * @param status
     * @param plane
     * @return
     */
    @PostMapping("/addFlight") //localhost:8080/addFlight
    public PlaneSchedule addFlight(String code, String airport, String destination, Date arrival, Date departure, String status, Plane plane){
        PlaneSchedule flight = new PlaneSchedule(code, airport, destination, arrival, departure, status, plane);
        System.out.println(manager.addFlight(flight));
        return flight;
    }

    /**
     * Metoda din cadrul patternului observer ce este apelata atunci cand se vrea adaugarea unui nou manager
     * @param o
     */
    @Override
    public void update(Object o) {
        managers.add((ATManager) o);
        System.out.println("ATManager added");
    }

    public List<ATManager> getManagers() {
        return managers;
    }

    public void setManagers(List<ATManager> managers) {
        this.managers = managers;
    }
}
