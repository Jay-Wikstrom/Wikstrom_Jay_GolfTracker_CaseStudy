package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.model.Courses;
import org.jaywikstrom.golftracker.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping("/courses")
    public String showCourses(Model model){
        List<Courses> listCourses = coursesService.listAll();
        model.addAttribute("listCourses", listCourses);
        return "courses";
    }
}
