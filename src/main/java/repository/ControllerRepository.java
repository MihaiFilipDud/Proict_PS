package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControllerRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");


}
