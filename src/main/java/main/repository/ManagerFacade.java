package main.repository;

import main.entity.Plane;
import main.entity.PlaneSchedule;
import org.springframework.stereotype.Component;

/**
 * Interfata de facade a backendului unui manager.
 */
@Component
public interface ManagerFacade {

    public static ManagerFacade getManagerRepository (){
        return new ManagerRepository();
    }
    String addPlane(Plane plane);
    String addFlight(PlaneSchedule flight);
}
