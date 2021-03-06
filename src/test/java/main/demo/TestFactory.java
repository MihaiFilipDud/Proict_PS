package main.demo;

import main.business.ControllerService;
import main.business.Login;
import main.business.ManagerService;
import main.entity.ATManager;
import main.entity.Account;
import main.entity.PlaneSchedule;
import main.entity.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import main.repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestFactory {

    @Mock
    LoginFacade loginFacade;
    ControllerFacade controllerFacade;
    ManagerFacade managerFacade;
    ControllerRepository controllerRepository;
    ArrayList<PlaneSchedule> schedule;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    private Login loginAPI;
    private ControllerService controllerService;
    private ManagerService managerService;
    //private ControllerRepository controllerRepository = new ControllerRepository();

    @Before
    public void init(){

        loginAPI = new Login(loginFacade);
        managerService = new ManagerService(managerFacade);
        controllerService = new ControllerService(controllerRepository);
        loginAPI.addObserver(controllerService);
        loginAPI.addObserver(managerService);

    }

    @Test
    public void succsessfulObserverTest(){
        Account account= new Account("dudu", "666");
        User expectedUser = new ATManager("Mihai Filip-Dud", new Date(), account, "TAROM");
        System.out.println(account);
        System.out.println(expectedUser);
        List<User> expected = new ArrayList<>();
        expected.add(expectedUser);
        when(loginFacade.login(account)).thenReturn(expectedUser);
        User result = loginAPI.tryLogin("dudu", "666");
        when(controllerService.getReport("PDF")).thenReturn("pdf_report");
        String report = controllerService.getReport("PDF");
        System.out.println(report);
        assertEquals(report.toString(), "pdf_report");
    }

}
