package main;

import main.business.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages={"main.repository", "main.entity"})
@ComponentScan(basePackageClasses = Login.class)
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {



		SpringApplication.run(DemoApplication.class, args);
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		//LoginRepository login = new LoginRepository();
		//Login loginAPI = new Login(login);
		//ManagerFacade managerFacade = new ManagerRepository();
		//ManagerService manager = new ManagerService(managerFacade);
		//loginAPI.addObserver(manager);
		//Account dudu = new Account("dudu", "666");
		//User dud = new ATManager("Mihai Filip-Dud", new Date(), dudu, "TAROM");
		//login.addAccount(dudu);
		//login.addUser(dud);

		//User user = loginAPI.tryLogin("dudu", "666");
		//System.out.println(user.getName());
		//User user = loginAPI.registerController("Andrei Costea", new Date(), "JFK", "dutu", "1234");
		//Account account = user.getAccount();
		//User user = loginAPI.tryLogin("dutu", "1234");
		//System.out.println(user);


		//Plane plane = manager.addPlane("123", "A380", "TAROM");
		//PlaneSchedule flight = manager.addFlight("123", "JFK", "Baneasa", new Date(), new Date(), "OK", plane);
	}

}
