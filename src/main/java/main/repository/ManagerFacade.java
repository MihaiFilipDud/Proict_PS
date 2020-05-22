package main.repository;

import main.entity.Plane;
import main.entity.PlaneSchedule;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Interfata de facade a backendului unui manager.
 */
@Component
public interface ManagerFacade {

    public static ManagerFacade getManagerRepository (){
        return new ManagerRepository();
    }
    String addPlane(Plane plane);
    String addFlight(String code, String airport, String destination, Date arrival, Date departure, String status, String plane);
}
