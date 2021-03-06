package main.demo;

import main.business.ControllerService;
import main.business.Login;
import main.business.ManagerService;
import main.entity.ATManager;
import main.entity.Account;
import main.entity.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import main.repository.ControllerFacade;
import main.repository.LoginFacade;
import main.repository.ManagerFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestObserver {

    @Mock
    LoginFacade loginFacade;
    ControllerFacade controllerFacade;
    ManagerFacade managerFacade;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    private Login loginAPI;
    private ControllerService controllerService;
    private ManagerService managerService;

    @Before
    public void init(){

        loginAPI = new Login(loginFacade);
        managerService = new ManagerService(managerFacade);
        controllerService = new ControllerService(controllerFacade);
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
