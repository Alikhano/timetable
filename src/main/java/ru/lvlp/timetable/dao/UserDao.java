package ru.lvlp.timetable.dao;

import ru.lvlp.timetable.entity.User;

public interface UserDao {
    User findByLogin(String login);
}
