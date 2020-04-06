package repository;

import entity.Plane;
import entity.PlaneSchedule;

/**
 * Interfata de facade a backendului unui controlor
 */

public interface ControllerFacade {

    String addPlane(Plane plane);
    String addFlight(PlaneSchedule flight);

}
