package ru.lvlp.timetable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TimetableDaoTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;
    private static TimetableDao t;

    @Test
    public void testGetAll_success() {
        Curriculum entry = new Curriculum("Business Law", "44", 17, 19, 1);
        t.addCourse(entry);
        List<Curriculum> list = t.listCourse();

        assertNotNull(list);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddCourse_sucess() {
        Curriculum entry = new Curriculum("Business Math", "42",8,11,1);
        Curriculum entry1 = new Curriculum("Business Math", "46",12,13,5);
        t.addCourse(entry);
        t.addCourse(entry1);

        List<Curriculum> list = em.createQuery("select u from Curriculum u", Curriculum.class).getResultList();

        assertNotNull(list);
        assertEquals(2, list.size());
    }

    @Test
    public void testDeleteCourse_success() {
        Curriculum entry = new Curriculum("Statistics & Data Analysis", "15", 8, 9, 2);
        t.addCourse(entry);

        t.deleteCourse(entry.getId());

        List<Curriculum> list = em.createQuery("select u from Curriculum u", Curriculum.class).getResultList();
        assertEquals(0, list.size());
    }

    @Test
    public void testUpdateCourse_success() {
        Curriculum entry = new Curriculum("Business English", "33",13,15,2);
        t.addCourse(entry);
        entry.setWeekDay(1);
        t.updateCourse(entry);
        Curriculum newEntry = (Curriculum) em.createQuery("select u from Curriculum u").getSingleResult();

        assertEquals(entry.getWeekDay(), 1);
    }

    @Test
    public void testSelectByWeekday_success() {
        Curriculum entry = new Curriculum("Intercultural communications", "33", 14, 15, 4);
        t.addCourse(entry);
        int weekday = 4;
        Curriculum selected = t.selectCourseByWeekday(weekday).get(0);

        assertEquals(weekday, selected.getWeekDay());
    }

    @Test
    public void testSelectByCourseName_success() {
        Curriculum entry = new Curriculum("Intercultural communications", "89",11,13,4);
        t.addCourse(entry);
        String courseName = "Intercultural communications";
        Curriculum selected = t.selectCourseByName(courseName).get(0);

        assertEquals(courseName, selected.getCourseName());
    }

    @Test
    public void findCourseById_sucess() {
        Curriculum entry = new Curriculum("Leadership skills", "67", 16, 17, 1);
        t.addCourse(entry);
        Curriculum returnedEntry = t.findCourseByGroupId(entry.getGroupId()).get(0);

        assertEquals(entry, returnedEntry);
    }

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("H2TestPersistenceUnit");
        em = entityManagerFactory.createEntityManager();
        t = new TimetableDao(em);
    }
    @After
    public  void tearDown() {
        em.clear();
        em.close();
        entityManagerFactory.close();
    }

}
