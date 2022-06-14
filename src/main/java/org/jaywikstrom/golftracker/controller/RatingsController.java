package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.exceptions.RatingsNotFoundException;
import org.jaywikstrom.golftracker.model.Courses;
import org.jaywikstrom.golftracker.model.Ratings;
import org.jaywikstrom.golftracker.service.CoursesService;
import org.jaywikstrom.golftracker.service.RatingsService;
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


    /*
        Return all ratings based on logged in users email
     */
    @GetMapping("/ratings")
    public String showRatings(Model model){
        List<Ratings> listRatings = ratingsService.listAllByUserEmail();
        model.addAttribute("listRatings", listRatings);

        return "ratings";
    }

    /*
        Form for user to add new ratings with
        select menu to select a golf course from database
     */
    @GetMapping("ratings/new")
    public String showNewRatingForm(Model model){
        model.addAttribute("rating", new Ratings());
        List<Courses> listCourses = coursesService.listAll();
        model.addAttribute("listCourses", listCourses);

        return "ratings_form";
    }

    /*
        Save user ratings form data to the database
     */
    @PostMapping("/ratings/save")
    public String saveRating(Ratings rating, RedirectAttributes ra){
        ratingsService.save(rating);
        return "redirect:/ratings";
    }


    /*
        Update the row of ratings based on rating id of that row
     */
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


    /*
        Delete the row of ratings based on the rating id of that row
     */
    @GetMapping("/ratings/delete/{id}")
    public String deleteScore(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            ratingsService.delete(id);
            ra.addFlashAttribute("message", "The score has been deleted");
        } catch (RatingsNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/ratings";
    }
}
