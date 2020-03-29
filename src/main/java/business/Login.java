package business;

import entity.Account;
import entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import repository.LoginFacade;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

public class Login {

    private LoginFacade login;

    public Login(LoginFacade loginFacade){
        this.login = loginFacade;
    }

    @GetMapping("/tryLogin") //localhost:8080/tryLogin
    public User tryLogin(String username, String password){
        Account logging = new Account(username, password);
        User user = login.login(logging);
        System.out.println(user);
        if(user == null){
            System.out.println("Login unsuccessful");
            return null;
        }else{
            System.out.println("Login successful");
            return user;
        }

    }

    @GetMapping("/registerManager") //localhost:8080/registerManager
    public User registerManager(String name, Date dob, String company, String username, String password){
        User user = login.registerManager(name,dob,company,username,password);
        System.out.println(user);
        if(user == null){
            System.out.println("Register unsuccessful");
            return null;
        }else{
            System.out.println("Register successful");
            return user;
        }
    }

    @GetMapping("/registerController") //localhost:8080/registerController
    public User registerController(String name, Date dob, String airport, String username, String password){
        User user = login.registerController(name,dob,airport,username,password);
        System.out.println(user);
        if(user == null){
            System.out.println("Register unsuccessful");
            return null;
        }else{
            System.out.println("Register successful");
            return user;
        }
    }


}
