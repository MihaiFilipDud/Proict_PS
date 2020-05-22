package main.repository;

import main.entity.ATController;
import main.entity.ATManager;
import main.entity.Account;
import main.entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;

/**
 * Clasa de main.repository ce realizeaza backendul operatiilor de login si register.
 */
@Component
public class LoginRepository implements LoginFacade {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");

    public LoginRepository(){};


    /**
     * Metoda primeste un obiect de tip account si realizeaza interogarea bazei de date pentru extragerea informatiilor utilizatorului in cazul unui login cu succes.
     * @param account
     * @return
     */
    @Override
    public User login(Account account) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Account search = entityManager.find(Account.class, account.getUsername());
        entityManager.getTransaction().commit();

        if(search == null){
            entityManager.close();
            System.out.println("No user");
            return null;
        }

        if(!account.getPassword().equals(search.getPassword())){
            entityManager.close();
            System.out.println("Invalid password");
        }

        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("SELECT u FROM User u WHERE username = '" + account.getUsername()+"'");
        entityManager.getTransaction().commit();
        User user = (User) q.getResultList().get(0);
        entityManager.close();

        if(user == null){
            return null;
        }

        System.out.println("Login successful");
        return user;
    }


    /**
     * Metoda realizeaza adaugarea unui nou cont de manager in baza de date aferenta.
     * @param name
     * @param dob
     * @param company
     * @param username
     * @param password
     * @return
     */
    @Override
    public User registerManager(String name, Date dob, String company, String username, String password) {
        Account account = new Account(username, password);
        ATManager manager = new ATManager(name, dob, account, company);
        addAccount(account);
        addUser(manager);
        return manager;
    }


    /**
     * Metoda realizeaza adaugarea unui nou cont de controlor in baza de date aferenta.
     * @param name
     * @param dob
     * @param airport
     * @param username
     * @param password
     * @return
     */
    @Override
    public User registerController(String name, Date dob, String airport, String username, String password) {
        Account account = new Account(username, password);
        ATController controller = new ATController(name, dob, account, airport);
        addAccount(account);
        addUser(controller);
        return controller;
    }


    /**
     * Metoda ce adauga un nou user in baza de date
     * @param user
     * @return
     */
    public String addUser(User user){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "User added";
    }

    /**
     * Metoda ce adauga un nou cont de utilizator in baza de date
     * @param account
     * @return
     */
    public String addAccount(Account account){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Account added";
    }
}
