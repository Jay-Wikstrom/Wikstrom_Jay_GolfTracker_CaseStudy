package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.model.Courses;
import org.jaywikstrom.golftracker.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/*
    This class is used to handle incoming requests,
    prepare the Courses model,
    and return the rendered view
 */

@Controller
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    /*
        Retrieved the list of courses from coursesService
        and render them on the courses page
     */

    @GetMapping("/courses")
    public String showCourses(Model model){
        List<Courses> listCourses = coursesService.listAll();
        model.addAttribute("listCourses", listCourses);
        return "courses";
    }

    /*
        Add a new course
        and render the courses form page
     */

    @GetMapping("courses/new")
    public String showNewCourseForm(Model model){
        model.addAttribute("course", new Courses());
        return "courses_form";
    }

    /*
        Save the course data to db
        and render the courses page with updated data
     */

    @PostMapping("/courses/save")
    public String saveCourse(Courses courses, RedirectAttributes ra){
        coursesService.save(courses);
        return "redirect:/courses";
    }
}
