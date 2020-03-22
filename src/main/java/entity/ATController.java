package entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name  = "ATControllers")
public class ATController extends User{

    @Column
    private String airport;

    public ATController(){}

    public ATController(String name, Date dob, Account account, String airport){
        super(name, dob, account);
        this.airport = airport;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }
}
