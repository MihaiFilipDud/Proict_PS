package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
/**
 * Clasa de entitate ce modeleaza baza de date al unui controlor de trafic aerian.
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ATController)) return false;
        ATController that = (ATController) o;
        return getAirport().equals(that.getAirport());
    }

    @Override
    public String toString() {
        return "ATController{" +
                "airport='" + airport + '\'' +
                "} " + super.toString();
    }
}
