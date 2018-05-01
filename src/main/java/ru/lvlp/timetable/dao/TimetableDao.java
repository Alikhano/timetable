package ru.lvlp.timetable.dao;

import org.springframework.stereotype.Repository;
import ru.lvlp.timetable.entity.Curriculum;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public Curriculum findCourseById(int id) {
        try{
            return (Curriculum)em.createQuery("select u from Curriculum u where u.id =: id").setParameter("id", id).getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }
}
