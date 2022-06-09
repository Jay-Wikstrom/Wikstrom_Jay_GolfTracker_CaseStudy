package org.jaywikstrom.golftracker.service;

import org.jaywikstrom.golftracker.model.Ratings;
import org.jaywikstrom.golftracker.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsService {
    @Autowired
    private RatingsRepository ratingsRepository;

    public List<Ratings> listAllByUserEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getDetails());
        System.out.println(auth.getName());
        String userEmail = auth.getName();

        return (List<Ratings>) ratingsRepository.findAllByUserEmail(userEmail);
    }
}
