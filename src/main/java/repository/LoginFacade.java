package repository;

import entity.Account;
import entity.User;

public interface LoginFacade  {

    User login (Account account);
}
