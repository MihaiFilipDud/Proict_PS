package business;

import entity.Account;
import entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import repository.LoginFacade;
import org.springframework.web.bind.annotation.*;

public class Login {

    private LoginFacade login;

    public Login(LoginFacade loginFacade){
        this.login = loginFacade;
    }

    @GetMapping("/tryLogin") //localhost:8080/tryLogin
    public User tryLogin(String username, String password){
        Account logging = new Account(username, password);
        User user = login.login(logging);
        if(user == null){
            System.out.println("Login successful");
        }
        return user;
    }

}
