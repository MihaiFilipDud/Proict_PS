package main.repository;

import main.entity.Account;
import main.entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Interfata de facade a backendului de login
 */
@Component
public interface LoginFacade  {

    public static LoginFacade getLoginRepository (){
        return new LoginRepository();
    }
    User login (Account account);
    User registerManager (String name, Date dob, String company, String username, String password);
    User registerController (String name, Date dob, String airport, String username, String password);
}
