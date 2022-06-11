package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.exceptions.RatingsNotFoundException;
import org.jaywikstrom.golftracker.model.Courses;
import org.jaywikstrom.golftracker.model.Ratings;
import org.jaywikstrom.golftracker.service.CoursesService;
import org.jaywikstrom.golftracker.service.RatingsService;
import org.jaywikstrom.golftracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class RatingsController {
    @Autowired
    private RatingsService ratingsService;

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private UserService userService;

    @GetMapping("/ratings")
    public String showRatings(Model model){
        List<Ratings> listRatings = ratingsService.listAllByUserEmail();
        model.addAttribute("listRatings", listRatings);

        return "ratings";
    }

    @GetMapping("ratings/new")
    public String showNewRatingForm(Model model){
        model.addAttribute("rating", new Ratings());
        List<Courses> listCourses = coursesService.listAll();
        model.addAttribute("listCourses", listCourses);
        return "ratings_form";
    }

    @PostMapping("/ratings/save")
    public String saveRating(Ratings rating, RedirectAttributes ra){
        ratingsService.save(rating);
        return "redirect:/ratings";
    }


    @GetMapping("/ratings/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Ratings rating = ratingsService.get(id);
            model.addAttribute("rating", rating);

            List<Courses> listCourses = coursesService.listAll();
            model.addAttribute("listCourses", listCourses);
            return "ratings_form";
        } catch (RatingsNotFoundException r){
            ra.addFlashAttribute("message", r.getMessage());
            return "redirect:/ratings";
        }
    }
}
