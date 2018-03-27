package ru.lvlp.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@Controller
@RequestMapping("/")
public class TimetableController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        return "hello";
    }

    private TimetableService timetableService;

    @Autowired
    @Qualifier(value = "timetableService")
    public void setTimetableService(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @RequestMapping(value = "/timetable", method = RequestMethod.GET)
    public String listCourse(Model model) {
       model.addAttribute("course", new Curriculum());
       model.addAttribute("listCourse", this.timetableService.listCourse());

        return "timetable";
    }

    @RequestMapping(value = "/timetable/find-id", method = RequestMethod.POST)
    public String displayFoundId(@RequestParam("groupId") String groupId, Model model){
        model.addAttribute("course", new Curriculum());
        model.addAttribute("listCourse",this.timetableService.findCourseByGroupId(groupId));

        return "find-course";
    }

    @RequestMapping(value = "/timetable/find-weekday", method = RequestMethod.POST)
    public String displayFoundWeekday(@RequestParam("weekday") int weekday, Model model){
        model.addAttribute("course", new Curriculum());
        model.addAttribute("listCourse",this.timetableService.selectCourseByWeekDay(weekday));

        return "find-course";
    }

    @RequestMapping(value = "/timetable/find-name", method = RequestMethod.POST)
    public String displayFoundName(@RequestParam("name") String name, Model model){
        model.addAttribute("course", new Curriculum());
        model.addAttribute("listCourse",this.timetableService.selectCourseByName(name));

        return "find-course";
    }

    @RequestMapping(value = "/timetable/add-course", method = RequestMethod.GET)
    public String listAddedCourse(Model model) {
        model.addAttribute("course", new Curriculum());
        model.addAttribute("listCourse", this.timetableService.listCourse());

        return "add-course";
    }

    @RequestMapping(value = "/timetable/add-course", method = RequestMethod.POST)
    public String addCourse(@RequestParam("courseName") String courseName,@RequestParam("weekDay") int weekDay, @RequestParam("startTime") int startTime, @RequestParam("endTime") int endTime, @RequestParam("groupId") String groupId, Model model){
        Curriculum course = new Curriculum(courseName, groupId, startTime, endTime, weekDay);
        model.addAttribute("course", course);
        if(course.getId() == 0){
            this.timetableService.addCourse(course);
        }else {
            this.timetableService.updateCourse(course);
        }
        model.addAttribute("listCourse", this.timetableService.listCourse());

        return "redirect:/timetable/add-course";
    }

    @RequestMapping(value = "/timetable/delete-course", method = RequestMethod.POST)
    public String deleteCourse(@RequestParam("id") int id, Model model) {
        this.timetableService.deleteCourse(id);
        model.addAttribute("listCourse", this.timetableService.listCourse());

        return "redirect:/timetable/add-course";
    }

}
