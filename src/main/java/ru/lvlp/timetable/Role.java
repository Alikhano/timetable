package ru.lvlp.timetable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
public class Role {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="role_id")
    private int roleId;

    @Id
    @Column(name = "role")
    private String role;

    @OneToMany
    @JoinTable(name = "roles_users",
    joinColumns = {@JoinColumn(name = "role", referencedColumnName = "role")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> userList;

    public int getId() {
        return roleId;
    }
    public void setId(int id) {
        this.roleId = roleId;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public List<User> getUserList() {
        return userList;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
