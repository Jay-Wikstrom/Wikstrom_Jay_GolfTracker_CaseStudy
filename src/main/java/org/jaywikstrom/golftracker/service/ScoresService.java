package org.jaywikstrom.golftracker.service;


import org.jaywikstrom.golftracker.model.Scores;
import org.jaywikstrom.golftracker.repository.ScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresService {
    @Autowired
    private ScoresRepository scoresRepository;

    public List<Scores> listAllByUserEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getDetails());
        System.out.println(auth.getName());
        String userEmail = auth.getName();
        return (List<Scores>) scoresRepository.findAllByUserEmail(userEmail);
    }
}
