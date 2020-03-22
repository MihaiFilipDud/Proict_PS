package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "User")
public abstract class User {

    @Id
    public final String id;

    @Column
    public final String name;

    @Column
    public final Date dob;

    @Column
    public final Date joiningDate;

    @OneToOne
    @JoinColumn(name = "username")
    public Account account;


    public User() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.dob = new Date();
        this.joiningDate = new Date();
    }

    public User(String name, Date dob, Account account) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.dob = dob;
        this.joiningDate =  new Date();
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
