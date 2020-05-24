package main.business;

import main.entity.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import main.repository.ManagerFacade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        Plane added = manager.addPlane(plane);
        System.out.println(added);
        return added;
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
    @CrossOrigin(origins = "*")
    public PlaneSchedule addFlight(String code, String airport, String destination, String arrival, String departure, String status, String plane){

        Date ar = new Date();
        Date dep = new Date();
        try {
            ar = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(arrival);
            dep = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(departure);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PlaneSchedule exec = manager.addFlight(code, airport, destination, ar, dep, status, plane);
        System.out.println(exec);
        return exec;
    }

    /**
     * Metoda corespunzatoare endpointului ce returneaza toate avioanele din baza de date de la aceeasi companie
     * @return
     */
    @GetMapping("/getPlanes") //localhost:8080/getPlanes
    @CrossOrigin(origins = "*")
    public List<Plane> getPlanes(String company){
        List<Plane> list= manager.getPlanes(company);
        return list;
    }

    /**
     * Metoda corespunzatoare endpointului ce sterge un avion din baza de date
     * @return
     */
    @PostMapping("/removePlane")
    @CrossOrigin(origins = "*")
    public String removePlane(String id){
        String ret = manager.deletePlane(id);
        System.out.println(ret);
        return ret;
    }

    /**
     * Metoda corespunzatoare endpointului ce sterge un zbor din baza de date
     * @return
     */
    @PostMapping("/removeFlight")
    @CrossOrigin(origins = "*")
    public String removeFlight(String code){
        String ret = manager.deleteFlight(code);
        System.out.println(ret);
        return ret;
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
