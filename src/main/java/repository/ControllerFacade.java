package repository;

import entity.Plane;
import entity.PlaneSchedule;

public interface ControllerFacade {

    String addPlane(Plane plane);
    String addFlight(PlaneSchedule flight);

}
