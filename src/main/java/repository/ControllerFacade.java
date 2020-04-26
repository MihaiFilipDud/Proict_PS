package repository;

import entity.Plane;
import entity.PlaneSchedule;

import java.util.List;

/**
 * Interfata de facade a backendului unui controlor
 */

public interface ControllerFacade {

    List<PlaneSchedule> getSchedule();
    String updateFlightStatus(String code, String status);
    String generateReport(String type);

}
