package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *Clasa de repository ce realizeaza backendul operatiilor de realizate de un controller.
 */


public class ControllerRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");


}
