package org.jaywikstrom.golftracker.service;

import org.jaywikstrom.golftracker.model.Ratings;
import org.jaywikstrom.golftracker.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsService {
    @Autowired
    private RatingsRepository ratingsRepository;

    public List<Ratings> listAll(){
        return (List<Ratings>) ratingsRepository.findAll();
    }
}
