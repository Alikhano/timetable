package ru.lvlp.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    public void addUser(UserInfo info) {
            em.getTransaction().begin();
            User user = new User(info.getLogin(), info.getPassword());
            em.persist(user);
            em.getTransaction().commit();
    }

    public User findByLogin(String login) {
        try {
            return em.createNamedQuery("FindByLogin", User.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException notFound) {
            return null;
        }
    }
}
