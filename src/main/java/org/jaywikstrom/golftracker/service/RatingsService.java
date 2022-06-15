package org.jaywikstrom.golftracker.service;

import org.jaywikstrom.golftracker.exceptions.RatingsNotFoundException;
import org.jaywikstrom.golftracker.model.Ratings;
import org.jaywikstrom.golftracker.model.User;
import org.jaywikstrom.golftracker.repository.RatingsRepository;
import org.jaywikstrom.golftracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingsService {
    @Autowired
    private RatingsRepository ratingsRepository;

    @Autowired
    private UserRepository userRepository;

    /*
        Get logged in users email
        List all the ratings from that user
     */
    public List<Ratings> listAllByUserEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();

        return (List<Ratings>) ratingsRepository.findAllByUserEmail(userEmail);
    }

    /*
        Get logged in users email
        Save users ratings
     */
    public void save(Ratings ratings){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();

        User user = userRepository.findByEmail(userEmail);
        Long userId = user.getId();

        ratingsRepository.save(ratings);
        Integer ratingId = ratings.getId();

        ratingsRepository.saveUserRatings(ratingId, userId);
    }

    /*
        Find the rating by id if id is present
     */
    public Ratings get(Integer id) throws RatingsNotFoundException {
        Optional<Ratings> result = ratingsRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new RatingsNotFoundException("Could not find any ratings with ID " + id);
    }

    /*
        Delete the rating by id if count not null or 0
     */
    public void delete(Integer id ) throws RatingsNotFoundException{
        Long count = ratingsRepository.countById(id);
        if(count == null || count == 0){
            throw new RatingsNotFoundException("Could not find any ratings with ID " + id);
        }
        ratingsRepository.deleteById(id);
    }

    public Long countCourseRating(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();

        User user = userRepository.findByEmail(userEmail);
        Long userId = user.getId();
        return ratingsRepository.countRatingsById(userId);
    }
}
