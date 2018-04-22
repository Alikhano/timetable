package ru.lvlp.timetable;

import java.util.List;

public interface UserDao {
    User findByLogin(String login);
}
