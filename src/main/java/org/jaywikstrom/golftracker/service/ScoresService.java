package org.jaywikstrom.golftracker.service;


import org.jaywikstrom.golftracker.exceptions.ScoresNotFoundException;
import org.jaywikstrom.golftracker.model.Scores;
import org.jaywikstrom.golftracker.model.User;
import org.jaywikstrom.golftracker.repository.ScoresRepository;
import org.jaywikstrom.golftracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoresService {
    @Autowired
    private ScoresRepository scoresRepository;

    @Autowired
    UserRepository userRepository;

    public List<Scores> listAllByUserEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getDetails());
        System.out.println(auth.getName());
        String userEmail = auth.getName();
        return (List<Scores>) scoresRepository.findAllByUserEmail(userEmail);
    }

    public void save(Scores scores){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();

        User user = userRepository.findByEmail(userEmail);
        Long userId = user.getId();

        scoresRepository.save(scores);

        Integer scoreId = scores.getId();
        scoresRepository.saveUserScores(scoreId, userId);
    }

    public Scores get(Integer id) throws ScoresNotFoundException{
        Optional<Scores> result = scoresRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ScoresNotFoundException("Could not find any scores with ID " + id);
    }
}
