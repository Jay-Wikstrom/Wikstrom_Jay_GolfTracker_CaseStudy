package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.exceptions.ScoresNotFoundException;
import org.jaywikstrom.golftracker.model.Courses;
import org.jaywikstrom.golftracker.model.Scores;
import org.jaywikstrom.golftracker.service.CoursesService;
import org.jaywikstrom.golftracker.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/*
    This class is used to handle incoming requests,
    prepare the Ratings model,
    and return the rendered view
 */

@Controller
public class ScoresController {
    @Autowired
    private ScoresService scoresService;

    @Autowired
    private CoursesService coursesService;


    /*
        Return all scores for logged in user
        render scores page
     */

    @GetMapping("/scores")
    public String showScores(Model model){
        List<Scores> listScores = scoresService.listAllByUserEmail();
        model.addAttribute("listScores", listScores);

        return "scores";
    }

    /*
        Add a new Score
        list of all golf courses in the db
        and render the scores form page
     */

    @GetMapping("/scores/new")
    public String showNewScoreForm(Model model){
        model.addAttribute("score", new Scores());
        List<Courses> listCourses = coursesService.listAll();
        model.addAttribute("listCourses", listCourses);
        return "scores_form";
    }

    /*
        Save the score data to db
        and render the scores page with updated data
     */

    @PostMapping("/scores/save")
    public String saveScore(Scores score, RedirectAttributes ra){
        scoresService.save(score);
        return "redirect:/scores";
    }

    /*
        Retrieve row of scores id
        add previous score row data
        list of all golf courses in the db
        render the scores form page with updated data
        or throw exceptions if rating not found
     */

    @GetMapping("/scores/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Scores score = scoresService.get(id);
            model.addAttribute("score", score);
            List<Courses> listCourses = coursesService.listAll();
            model.addAttribute("listCourses", listCourses);
            return "scores_form";
        } catch(ScoresNotFoundException s){
            ra.addFlashAttribute("message", s.getMessage());
            return "redirect:/scores";
        }
    }

    /*
       Retrieve row of scores id
        delete row
        render the scores page with row deleted
        or throw exceptions if score not found
     */

    @GetMapping("/scores/delete/{id}")
    public String deleteScore(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            scoresService.delete(id);
            ra.addFlashAttribute("message", "The score has been deleted");
        } catch (ScoresNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/scores";
    }
}
