package main.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


/**
 * Clasa de entitate ce modeleaza baza de date al unui avion.
 */
@Entity(name = "Plane")
public class Plane {

    @Id
    @Column(name = "ID",unique=true, nullable = false)
    private String ID;

    @Column
    private String model;

    @Column
    private String company;

   @OneToOne(mappedBy = "plane")
   @JsonIgnore
    private PlaneSchedule PlaneSchedule;

    public Plane(){

    }

    public Plane(String id, String model, String company){
        this.ID = id;
        this.model = model;
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return getID().equals(plane.getID()) &&
                getModel().equals(plane.getModel()) &&
                getCompany().equals(plane.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getModel(), getCompany());
    }

    @Override
    public String toString() {
        return "Plane{" +
                "ID='" + ID + '\'' +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
