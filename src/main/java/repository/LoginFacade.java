package repository;

import entity.Account;
import entity.User;

import java.util.Date;

public interface LoginFacade  {

    User login (Account account);
    User registerManager (String name, Date dob, String company, String username, String password);
    User registerController (String name, Date dob, String airport, String username, String password);
}
