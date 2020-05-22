package main.business;

import main.entity.ATController;
import main.entity.PlaneSchedule;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import main.repository.ControllerFacade;

import java.util.ArrayList;
import java.util.List;

/**
 *  Clasa se ocupa de de operatiile realizate de un manager de trafic aerian.
 */
@RestController
public class ControllerService implements UserService{

    private ControllerFacade controller = ControllerFacade.getControllerRepository();
    private List<ATController> controllers = new ArrayList<>();

    public ControllerService(){};

    public ControllerService(ControllerFacade controller){
        this.controller = controller;
    }

    /**
     * Metoda ce se ocupa cu apelarea metodei din main.repository ce va genera raportul prin design factory in functie de tipul fisierului ales.
     * @param type
     * @return
     */
    @PostMapping("/getReport")
    @CrossOrigin(origins = "*")
    public String getReport(String type){
        return controller.generateReport(type);
    }

    /**
     * Metoda ce returneaza intreg programul de zboruri
     * @return
     */
    @GetMapping("/getSchedule")
    @CrossOrigin(origins = "*")
    public List<PlaneSchedule> getSchedule(){
        return controller.getSchedule();
    }

    /**
     * Metoda ce updateaza statusul unui zbor
     * @param code
     * @param status
     * @return
     */
    @PostMapping("/updateFlight")
    @CrossOrigin(origins = "*")
    public String updateFlightStatus(String code, String status){
        return controller.updateFlightStatus(code, status);
    }

    @Override
    public void update(Object o) {
        controllers.add((ATController) o);
        System.out.println("ATController added");
    }


}
