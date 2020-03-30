package business;

import entity.ATController;
import entity.ATManager;

import java.util.ArrayList;
import java.util.List;

public class ControllerService implements UserService{

    private List<ATController> controllers = new ArrayList<>();


    @Override
    public void update(Object o) {
        controllers.add((ATController) o);
        System.out.println("ATController added");
    }
}
