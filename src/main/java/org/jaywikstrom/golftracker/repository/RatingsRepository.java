package org.jaywikstrom.golftracker.repository;

import org.jaywikstrom.golftracker.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/*
    This class provides data access to the DB
 */
public interface RatingsRepository extends JpaRepository<Ratings, Integer> {

    // Select all the ratings where the email is equal to the logged in user
    @Query(value = "SELECT r FROM Ratings r JOIN r.userRatings ur WHERE ur.email = :userEmail")
    List <Ratings> findAllByUserEmail(@Param("userEmail") String userEmail);

    // Insert ratings id and user id into the joined userScores table
    @Query(value = "INSERT INTO userRatings(ratingsId, userId) VALUES (:ratingsId, :userId)", nativeQuery = true)
    public void saveUserRatings(@Param("ratingsId") Integer ratingId, @Param("userId") Long userId);

    // Count all the ratings by the users id
    @Query(value = "SELECT COUNT(r) FROM Ratings r JOIN r.userRatings ur WHERE ur.id = :userId")
    public Long countRatingsById(Long userId);

    // Count by ud
    public Long countById(Integer id);

}
