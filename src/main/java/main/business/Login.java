package main.business;

import main.entity.ATManager;
import main.entity.Account;
import main.entity.User;
import main.repository.LoginFacade;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Aceasta clasa se ocupa de operatiile de login si de register ale utilizatorilor.
 */

@RestController
public class Login {

    private LoginFacade login = LoginFacade.getLoginRepository();
    private List<UserService>observers = new ArrayList<>();


    public Login(){};

    public Login(LoginFacade loginFacade){
        this.login = loginFacade;
    }

    /**
     * Metoda reprezinta endpointul pentru login
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/tryLogin") //localhost:8080/tryLogin
    @CrossOrigin(origins = "*")
    public User tryLogin(String username, String password){
        Account logging = new Account(username, password);
        User user = login.login(logging);
        System.out.println(user);
        if(user == null){
            System.out.println("Login unsuccessful");
            return null;
        }else{
            System.out.println("Login successful");
            notifyObservers(user);
            //user.setAccount(logging);
            return user;
        }

    }

    /**
     * Metoda este ednpointul pentru inregistrarea unui nou ATManager
     * @param name
     * @param dob
     * @param company
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/registerManager") //localhost:8080/registerManager
    @CrossOrigin(origins = "*")
    public User registerManager(String name, String dob, String company, String username, String password){
        Date dob_d = new Date();

        try {
            dob_d = new SimpleDateFormat("dd/MM/yyyy").parse(dob);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = login.registerManager(name,dob_d,company,username,password);
        System.out.println(user);
        if(user == null){
            System.out.println("Register unsuccessful");
            return null;
        }else{
            System.out.println("Register successful");
            return user;
        }
    }

    /**
     * Metoda este endpointul pentru inregistrarea unui nou ATController
     * @param name
     * @param dob
     * @param airport
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/registerController") //localhost:8080/registerController
    @CrossOrigin(origins = "*")
    public User registerController(String name, String dob, String airport, String username, String password){
        Date dob_d = new Date();
        try {
            dob_d = new SimpleDateFormat("dd/MM/yyyy").parse(dob);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = login.registerController(name,dob_d,airport,username,password);
        System.out.println(user);
        if(user == null){
            System.out.println("Register unsuccessful");
            return null;
        }else{
            System.out.println("Register successful");
            return user;
        }
    }


    public void addObserver(UserService service){
        this.observers.add(service);
    }

    public void removeObserver(UserService service){
        this.observers.remove(service);
    }

    public void notifyObservers(User user){
        if(user instanceof ATManager){
            for(UserService service: observers){
                if(service instanceof ManagerService){
                    service.update(user);
                }
            }
        }else{
            for(UserService service: observers){
                if(service instanceof ControllerService){
                    service.update(user);
                }
            }
        }
    }

}
