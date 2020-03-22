package entity;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "account")
public class Account {

    @Column
    private final String id;

    @Id
    private String username;

    @Column
    private String password;

    @OneToOne(mappedBy = "account")
    private User user;

    public Account(String username, String password){
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }
}
