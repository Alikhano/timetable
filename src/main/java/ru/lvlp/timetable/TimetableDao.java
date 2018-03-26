package ru.lvlp.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sun.util.resources.cldr.id.CurrencyNames_id;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TimetableDao {

    private EntityManager em;

    public TimetableDao(EntityManager em) {
        this.em = em;
    }

    public void addCourse(Curriculum timetable) {
        em.getTransaction().begin();
        em.persist(timetable);
        em.getTransaction().commit();
    }

    public void deleteCourse(int id) {

        try {
            Curriculum deletedEntry = em.find(Curriculum.class, id);
            em.getTransaction().begin();
            em.remove(deletedEntry);
            em.getTransaction().commit();
        }
        catch (Throwable t) {
            em.getTransaction().rollback();
        }

    }

    public List<Curriculum> listCourse() {
        try{
            return em.createQuery("select e from Curriculum e").getResultList();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public void updateCourse (Curriculum changeEntry) {
        em.getTransaction().begin();
        em.merge(changeEntry);
        em.getTransaction().commit();

    }

    public List<Curriculum> selectCourseByName(String courseName) {

        try{
            return em.createQuery("select u from Curriculum u where u.courseName =: courseName").setParameter("courseName", courseName).getResultList();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Curriculum> selectCourseByWeekday(int weekday) {
        try{
            return em.createQuery("select u from Curriculum u where u.weekDay =: weekday").setParameter("weekday", weekday).getResultList();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Curriculum> findCourseByGroupId(String groupId) {
        try{
            return em.createQuery("select u from Curriculum u where u.groupId =: groupId").setParameter("groupId", groupId).getResultList();
        }
        catch (NoResultException e) {
            return null;
        }
    }


}
