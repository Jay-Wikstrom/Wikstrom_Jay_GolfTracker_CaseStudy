package org.jaywikstrom.golftracker.controller;

import org.jaywikstrom.golftracker.model.Scores;
import org.jaywikstrom.golftracker.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ScoresController {
    @Autowired
    private ScoresService scoresService;

    @GetMapping("/scores")
    public String showScores(Model model){
        List<Scores> listScores = scoresService.listAllByUserEmail();
        model.addAttribute("listScores", listScores);

        return "scores";
    }
}
