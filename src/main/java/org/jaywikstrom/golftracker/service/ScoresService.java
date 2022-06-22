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
        Get logged in users id
        Save users scores to scores table
        Get score id
        and save score id and user id to user scores join table
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
        or throw score not found exception if id does not exist
    */

    public Scores get(Integer id) throws ScoresNotFoundException{
        Optional<Scores> result = scoresRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ScoresNotFoundException("Could not find any scores with ID " + id);
    }

    /*
        Count score by id
        Throw exception if count is null or not = 0
        or delete score if count exists
     */

    public void delete(Integer id) throws ScoresNotFoundException{
        Long count = scoresRepository.countById(id);
        if(count == null || count == 0){
            throw new ScoresNotFoundException("Could not find any scores with ID " +id);
        }
        scoresRepository.deleteById(id);
    }

    /*
        Get logged in users email
        Get logged in users id
        Return number of courses user has played
     */

    public Long countCourseScores(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();

        User user = userRepository.findByEmail(userEmail);
        Long userId = user.getId();
        return scoresRepository.countScoresById(userId);
    }

}
