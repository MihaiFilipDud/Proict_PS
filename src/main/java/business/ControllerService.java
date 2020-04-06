package business;

import entity.ATController;
import entity.ATManager;

import java.util.ArrayList;
import java.util.List;

/**
 *  Clasa se ocupa de de operatiile realizate de un manager de trafic aerian.
 */

public class ControllerService implements UserService{

    private List<ATController> controllers = new ArrayList<>();


    @Override
    public void update(Object o) {
        controllers.add((ATController) o);
        System.out.println("ATController added");
    }
}
