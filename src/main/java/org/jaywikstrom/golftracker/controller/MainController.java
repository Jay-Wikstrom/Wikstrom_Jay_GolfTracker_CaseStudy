package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.repository.RatingsRepository;
import org.jaywikstrom.golftracker.service.RatingsService;
import org.jaywikstrom.golftracker.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    RatingsService ratingsService;

    @Autowired
    ScoresService scoresService;

    @GetMapping("/")
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/user")
    public String userIndex(){
        return "user/index";
    }

    @GetMapping("/index")
    public String countRoundsPlayedAndRatings(Model model){
        Long countRatings = ratingsService.countCourseRating();
        model.addAttribute("countRatings", countRatings);
        Long countScores = scoresService.countCourseScores();
        model.addAttribute("countScores", countScores);
        return "index";
    }
}
