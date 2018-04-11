package ru.lvlp.timetable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
@Transactional
public class UserInfoDao {
    private EntityManager em;

    public UserInfoDao(){};

    public UserInfoDao(EntityManager em) {
        this.em = em;
    }

    public UserInfo findUserInfo(String login) {
        try{
            return (UserInfo) em.createQuery("select u from User u where u.login =: login").setParameter("login", login).getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Role> getRoles(String login) {
        try{
            return em.createQuery("select u.role from User u where u.login = :login").setParameter("login", login).getResultList();
        }
        catch (NoResultException e) {
            return null;
        }
    }

}
