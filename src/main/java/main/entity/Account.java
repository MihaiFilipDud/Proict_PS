package main.entity;

import javax.persistence.*;

/**
 * Clasa de entitate pentru baza de date corespunzatoare conturilor de utilizatori.
 */

@Entity(name = "account")
public class Account {

    @Id
    private String username;

    @Column
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    public Account(){
    }

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getUsername().equals(account.getUsername()) &&
                getPassword().equals(account.getPassword());
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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


}
