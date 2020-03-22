package com.example.sd2020.demo;

import business.Login;
import entity.ATManager;
import entity.Account;
import entity.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import repository.LoginFacade;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Date;

public class TestLogin {

    @Mock
    LoginFacade loginFacade;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private Login loginAPI;

    @Before
    public void init(){
        loginAPI = new Login(loginFacade);
    }

    @Test
    public void succsessfulLoginTest(){
        Account account= new Account("dudu", "666");
        User expected = new ATManager("Mihai Filip-Dud", new Date(), account, "TAROM");

        when(loginFacade.login(account)).thenReturn(expected);
        User result = loginAPI.tryLogin("dudu", "666");
        assertEquals(expected, result);
        verify(loginFacade).login(account);
    }

    @Test
    public void faillLoginTest(){
        Account account= new Account("dudu", "666");


        when(loginFacade.login(account)).thenReturn(null);
        User result = loginAPI.tryLogin("dudu", "666");
        assertEquals(null, result);
        verify(loginFacade).login(account);
    }




}
