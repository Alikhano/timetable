package ru.lvlp.timetable.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
@NamedQueries(
        @NamedQuery(
                name = "FindByLogin",
                query = "select u from User u where u.login = :login"
        )
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    private String login;
    private String password;
    private boolean enabled;
    @ManyToOne
    private Role role;


    public User(){}

    public User(String login, String password, boolean enabled) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
