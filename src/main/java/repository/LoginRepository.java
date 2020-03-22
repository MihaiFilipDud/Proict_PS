package repository;

import entity.ATController;
import entity.Account;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LoginRepository implements LoginFacade {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");

    public LoginRepository(){};

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

        Query q = entityManager.createNamedQuery("SELECT N FROM N WHERE username = '" + account.getUsername()+"'");
        entityManager.getTransaction().commit();
        User user = (User) q.getResultList().get(0);
        entityManager.close();

        if(user == null){
            return null;
        }

        System.out.println("Login successful");
        System.out.println(user instanceof ATController);

        return user;
    }
}
