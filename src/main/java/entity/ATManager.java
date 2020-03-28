package entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "Atmanagers")
public class ATManager extends User{

    @Column
    private String company;

    public  ATManager(){}

    public ATManager(String name, Date dob, Account account, String company){
        super(name, dob, account);
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ATManager)) return false;
        if (!super.equals(o)) return false;
        ATManager atManager = (ATManager) o;
        return getCompany().equals(atManager.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCompany());
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "ATManager{" +
                "company='" + company + '\'' +
                "} " + super.toString();
    }
}
