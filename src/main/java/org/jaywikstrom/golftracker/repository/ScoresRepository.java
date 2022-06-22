package org.jaywikstrom.golftracker.repository;

import org.jaywikstrom.golftracker.model.Scores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/*
    This class provides data access to the DB
 */
public interface ScoresRepository extends JpaRepository <Scores, Integer> {
    // Select all the scores where the email is equal to the logged in user
    @Query(value = "SELECT s FROM Scores s JOIN s.userScores us WHERE us.email = :userEmail")
    List<Scores> findAllByUserEmail(@Param("userEmail") String userEmail);

    // Insert score id and user id into the joined userScores table
    @Query(value = "INSERT INTO userScores(scoresId, userId) VALUES (:scoresId, :userId)", nativeQuery = true)
    public void saveUserScores(@Param("scoresId") Integer scoresId, @Param("userId") Long userId);

    // Count all the scores by the users id
    @Query(value = "SELECT COUNT(s) FROM Scores s JOIN s.userScores us WHERE us.id = :userId")
    public Long countScoresById(Long userId);

    // Count by id
    public Long countById(Integer id);
}
