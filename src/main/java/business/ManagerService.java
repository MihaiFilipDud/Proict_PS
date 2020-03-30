package business;

import entity.*;
import org.springframework.web.bind.annotation.GetMapping;
import repository.ManagerFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerService implements UserService{

    private ManagerFacade manager;
    private List<ATManager> managers = new ArrayList<>();

    public ManagerService(ManagerFacade manager){
        this.manager = manager;
    }

    @GetMapping("/addPlane") //localhost:8080/addPlane
    public Plane addPlane(String id, String model, String company){
        Plane plane = new Plane(id, model, company);
        System.out.println(manager.addPlane(plane));
        return plane;
    }

    @GetMapping("/addPlane") //localhost:8080/addPlane
    public PlaneSchedule addFlight(String code, String airport, String destination, Date arrival, Date departure, String status, Plane plane){
        PlaneSchedule flight = new PlaneSchedule(code, airport, destination, arrival, departure, status, plane);
        System.out.println(manager.addFlight(flight));
        return flight;
    }

    @Override
    public void update(Object o) {
        managers.add((ATManager) o);
        System.out.println("ATManager added");
    }
}
