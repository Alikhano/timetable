package ru.lvlp.timetable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.lvlp.timetable.dao.UserDaoImpl;
import ru.lvlp.timetable.entity.User;
import ru.lvlp.timetable.entity.UserInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;
    private static UserDaoImpl info;

    @Test
    public void findUserInfo_sucess() {
        UserInfo test1 = new UserInfo("student1", "1234");
        info.addUser(test1);
        User test = info.findByLogin(test1.getLogin());
        assertEquals(test1.getLogin(), test.getLogin());
    }

    public void getRoles_success() {

    }


    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("H2TestPersistenceUnit");
        em = entityManagerFactory.createEntityManager();
        info = new UserDaoImpl(em);
    }
    @After
    public  void tearDown() {
        em.clear();
        em.close();
        entityManagerFactory.close();
    }
}
