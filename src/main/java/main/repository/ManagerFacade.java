package main.repository;

import main.entity.Plane;
import main.entity.PlaneSchedule;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Interfata de facade a backendului unui manager.
 */
@Component
public interface ManagerFacade {

    public static ManagerFacade getManagerRepository (){
        return new ManagerRepository();
    }
    Plane addPlane(Plane plane);
    PlaneSchedule addFlight(String code, String airport, String destination, Date arrival, Date departure, String status, String plane);
    List<Plane> getPlanes();
    String deletePlane(String id);
    String deleteFlight(String code);
}
