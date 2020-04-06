package repository;

import entity.Plane;
import entity.PlaneSchedule;

/**
 * Interfata de facade a backendului unui manager.
 */

public interface ManagerFacade {

    String addPlane(Plane plane);
    String addFlight(PlaneSchedule flight);
}
