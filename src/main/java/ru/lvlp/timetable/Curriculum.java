package ru.lvlp.timetable;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "CURRICULUM")
public class Curriculum {

    @Id
    @Column(name = "curriculum_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "start_time")
    private int startTime;

    @Column(name = "end_time")
    private int endTime;

    @Column(name = "week_day")
    private int weekDay;

    public Curriculum(String courseName, String groupId, int startTime, int endTime, int weekDay) {
        this.courseName = courseName;
        this.groupId = groupId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
    }

    public Curriculum(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", groupId=" + groupId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", weekDay='" + weekDay + '\'' +
                '}';
    }
}
