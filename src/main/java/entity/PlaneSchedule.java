package entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Plane")
public class PlaneSchedule {

    @Id
    private String code;

    @Column
    private String airport;

    @Column
    private String destination;

    @Column
    private Date arrival;

    @Column
    private Date departure;

    @Column
    private String status;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plane_id", referencedColumnName = "ID")
    private Plane plane;

    public PlaneSchedule() {
    }

    public PlaneSchedule(String code, String airport, String destination, Date arrival, Date departure, String status, Plane plane) {
        this.code = code;
        this.airport = airport;
        this.arrival = arrival;
        this.destination = destination;
        this.departure = departure;
        this.status = status;
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "PlaneSchedule{" +
                "code='" + code + '\'' +
                ", airport='" + airport + '\'' +
                ", destination='" + destination + '\'' +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", status='" + status + '\'' +
                ", plane=" + plane +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
