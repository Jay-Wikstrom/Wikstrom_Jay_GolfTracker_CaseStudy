package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.exceptions.ScoresNotFoundException;
import org.jaywikstrom.golftracker.model.Courses;
import org.jaywikstrom.golftracker.model.Scores;
import org.jaywikstrom.golftracker.service.CoursesService;
import org.jaywikstrom.golftracker.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ScoresController {
    @Autowired
    private ScoresService scoresService;

    @Autowired
    private CoursesService coursesService;

    @GetMapping("/scores")
    public String showScores(Model model){
        List<Scores> listScores = scoresService.listAllByUserEmail();
        model.addAttribute("listScores", listScores);

        return "scores";
    }

    @GetMapping("/scores/new")
    public String showNewScoreForm(Model model){
        model.addAttribute("score", new Scores());
        List<Courses> listCourses = coursesService.listAll();
        model.addAttribute("listCourses", listCourses);
        return "scores_form";
    }

    @PostMapping("/scores/save")
    public String saveScore(Scores score, RedirectAttributes ra){
        scoresService.save(score);
        return "redirect:/scores";
    }

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
