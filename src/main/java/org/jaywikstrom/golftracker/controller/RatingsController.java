package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.model.Ratings;
import org.jaywikstrom.golftracker.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RatingsController {
    @Autowired
    private RatingsService ratingsService;

    @GetMapping("/ratings")
    public String showRatings(Model model){
        List<Ratings> listRatings = ratingsService.listAll();
        model.addAttribute("listRatings", listRatings);

        return "ratings";
    }
}
