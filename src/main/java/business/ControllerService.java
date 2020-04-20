package business;

import entity.ATController;
import entity.ATManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.ControllerFacade;
import repository.ManagerFacade;

import java.util.ArrayList;
import java.util.List;

/**
 *  Clasa se ocupa de de operatiile realizate de un manager de trafic aerian.
 */
@RestController
public class ControllerService implements UserService{

    private ControllerFacade controller;
    private List<ATController> controllers = new ArrayList<>();

    public ControllerService(ControllerFacade controller){
        this.controller = controller;
    }

    /**
     * Metoda ce se ocupa cu apelarea metodei din repository ce va genera raportul prin design factory in functie de tipul fisierului ales.
     * @param type
     * @return
     */
    @PostMapping("/getReport")
    public String getReport(String type){
        return controller.generateReport(type);
    }

    @Override
    public void update(Object o) {
        controllers.add((ATController) o);
        System.out.println("ATController added");
    }


}
