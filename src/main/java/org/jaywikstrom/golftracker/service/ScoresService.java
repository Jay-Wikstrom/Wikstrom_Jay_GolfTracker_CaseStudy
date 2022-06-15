package org.jaywikstrom.golftracker.service;

import org.jaywikstrom.golftracker.exceptions.ScoresNotFoundException;
import org.jaywikstrom.golftracker.model.Scores;
import org.jaywikstrom.golftracker.model.User;
import org.jaywikstrom.golftracker.repository.ScoresRepository;
import org.jaywikstrom.golftracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoresService {
    @Autowired
    private ScoresRepository scoresRepository;

    @Autowired
    UserRepository userRepository;

    /*
        Get logged in users email
        List all the scores from that user
     */
    public List<Scores> listAllByUserEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        return (List<Scores>) scoresRepository.findAllByUserEmail(userEmail);
    }

    /*
        Get logged in users email
        Save users scores
     */
    public void save(Scores scores){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();

        User user = userRepository.findByEmail(userEmail);
        Long userId = user.getId();

        scoresRepository.save(scores);

        Integer scoreId = scores.getId();
        scoresRepository.saveUserScores(scoreId, userId);
    }

    /*
       Find the score by id if id is present
    */
    public Scores get(Integer id) throws ScoresNotFoundException{
        Optional<Scores> result = scoresRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ScoresNotFoundException("Could not find any scores with ID " + id);
    }

    /*
        Delete the score by id if count not null or 0
     */
    public void delete(Integer id) throws ScoresNotFoundException{
        Long count = scoresRepository.countById(id);
        if(count == null || count == 0){
            throw new ScoresNotFoundException("Could not find any scores with ID " +id);
        }
        scoresRepository.deleteById(id);
    }

    public Long countCourseScores(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();

        User user = userRepository.findByEmail(userEmail);
        Long userId = user.getId();
        return scoresRepository.countScoresById(userId);
    }

}
