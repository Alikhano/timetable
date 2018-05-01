package ru.lvlp.timetable.entity;

public class UserInfo {
    private String login;
    private String password;

    public UserInfo()  {}

    public UserInfo(String userName, String password) {
        this.login = userName;
        this.password = password;
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
}
