package entity;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "ATManagers")
public class ATManager extends User{

    @Column
    private String company;

    public  ATManager(){}

    public ATManager(String name, Date dob, Account account, String company){
        super(name, dob, account);
        this.company = company;
    }
}
