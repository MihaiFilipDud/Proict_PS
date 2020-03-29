package repository;

import entity.Plane;
import entity.PlaneSchedule;

public interface ManagerFacade {

    String addPlane(Plane plane);
    String addFlight(PlaneSchedule flight);
}
