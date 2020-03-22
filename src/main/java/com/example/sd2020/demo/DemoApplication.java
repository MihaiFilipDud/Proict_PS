package com.example.sd2020.demo;

import business.Login;
import entity.ATManager;
import entity.Account;
import entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.LoginFacade;
import repository.LoginRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {



		//SpringApplication.run(DemoApplication.class, args);
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		LoginRepository login = new LoginRepository();
		Account dudu = new Account("dudu", "666");
		User dud = new ATManager("Mihai Filip-Dud", new Date(), dudu, "TAROM");
		login.addAccount(dudu);
		login.addUser(dud);
		Login loginAPI = new Login(login);
		User user = loginAPI.tryLogin("dudu", "666");
		System.out.println(user.getName());

	}

}