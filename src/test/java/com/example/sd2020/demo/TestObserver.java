package com.example.sd2020.demo;

import business.ControllerService;
import business.Login;
import business.ManagerService;
import business.UserService;
import entity.ATManager;
import entity.Account;
import entity.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import repository.ControllerFacade;
import repository.LoginFacade;
import repository.ManagerFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestObserver {

    @Mock
    LoginFacade loginFacade;
    //ControllerService controllerService;
    ManagerFacade managerFacade;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private Login loginAPI;
    private ControllerService controllerService = new ControllerService();
    private ManagerService managerService;

    @Before
    public void init(){

        loginAPI = new Login(loginFacade);
        managerService = new ManagerService(managerFacade);
        loginAPI.addObserver(controllerService);
        loginAPI.addObserver(managerService);

    }

    @Test
    public void succsessfulObserverTest(){
        Account account= new Account("dudu", "666");
        User expectedUser = new ATManager("Mihai Filip-Dud", new Date(), account, "TAROM");
        System.out.println(account);
        System.out.println(expectedUser);
        List<User>expected = new ArrayList<>();
        expected.add(expectedUser);
        when(loginFacade.login(account)).thenReturn(expectedUser);
        List<ATManager> managers = managerService.getManagers();
        User result = loginAPI.tryLogin("dudu", "666");
        assertEquals(expected.get(0), managers.get(0));
        verify(loginFacade).login(account);
    }

}
