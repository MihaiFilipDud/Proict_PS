package main.repository;

import main.entity.PlaneSchedule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Interfata de facade a backendului unui controlor
 */

@Component

public interface ControllerFacade {

    public static ControllerFacade getControllerRepository (){
        return new ControllerRepository();
    }

    List<PlaneSchedule> getSchedule();
    String updateFlightStatus(String code, String status);
    String generateReport(String type);

}
