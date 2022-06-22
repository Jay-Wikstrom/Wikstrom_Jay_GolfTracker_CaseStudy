package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.service.RatingsService;
import org.jaywikstrom.golftracker.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
    This class is used to handle incoming requests,
    prepare the model,
    and return the rendered view
 */

@Controller
public class MainController {

    @Autowired
    RatingsService ratingsService;

    @Autowired
    ScoresService scoresService;

    // Render the home page
    @GetMapping("/")
    public String root(){
        return "index";
    }

    // Render the login page
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    /*
        Render the index page
        Display the number of courses the logged in user has rated
        Display the number of courses the logged in user has played at
     */

    @GetMapping("/index")
    public String countRoundsPlayedAndRatings(Model model){
        Long countRatings = ratingsService.countCourseRating();
        model.addAttribute("countRatings", countRatings);
        Long countScores = scoresService.countCourseScores();
        model.addAttribute("countScores", countScores);
        return "index";
    }
}
