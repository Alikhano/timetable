package ru.lvlp.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lvlp.timetable.entity.Curriculum;
import ru.lvlp.timetable.dao.TimetableDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TimetableService {

    @Autowired
    TimetableDao timetableDao;

   @org.springframework.transaction.annotation.Transactional
    public void addCourse(Curriculum timetable) {
        this.timetableDao.addCourse(timetable);
    }

    @Transactional
    public void deleteCourse(int id) {
        this.timetableDao.deleteCourse(id);
    }

    @Transactional
    public List<Curriculum> listCourse() {
        return this.timetableDao.listCourse();
    }

    @Transactional
    public void updateCourse(Curriculum changeEntry) {
        this.timetableDao.updateCourse(changeEntry);
    }

    @Transactional
    public List<Curriculum> selectCourseByName(String courseName) {
        return this.timetableDao.selectCourseByName(courseName);
    }

    @Transactional
    public List<Curriculum> selectCourseByWeekDay(int weekDay) {
        return this.timetableDao.selectCourseByWeekday(weekDay);
    }

    @Transactional
    public List<Curriculum> findCourseByGroupId(String groupId) {
        return this.timetableDao.findCourseByGroupId(groupId);
    }

    @Transactional
    public Curriculum findCourseById(int id) {
       return this.timetableDao.findCourseById(id);
    }
}
