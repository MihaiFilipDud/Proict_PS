package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "User")
public abstract class User {

    @Id
    private final String id;

    @Column
    private final String name;

    @Column
    private final Date dob;

    @Column
    private final Date joiningDate;

    @OneToOne
    @JoinColumn(name = "username")
    private Account account;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) &&
                getName().equals(user.getName()) &&
                getDob().equals(user.getDob()) &&
                getJoiningDate().equals(user.getJoiningDate()) &&
                getAccount().equals(user.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDob(), getJoiningDate(), getAccount());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", joiningDate=" + joiningDate +
                '}';
    }

    public String getId() {
        return id;
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
