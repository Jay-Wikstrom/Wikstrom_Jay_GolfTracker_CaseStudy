package org.jaywikstrom.golftracker.repository;

import org.jaywikstrom.golftracker.model.Scores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoresRepository extends JpaRepository <Scores, Integer> {
    @Query(value = "SELECT s FROM Scores s JOIN s.userScores us WHERE us.email = :userEmail")
    List<Scores> findAllByUserEmail(@Param("userEmail") String userEmail);

    @Query(value = "INSERT INTO userScores(scoresId, userId) VALUES (:scoresId, :userId)", nativeQuery = true)
    public void saveUserScores(@Param("scoresId") Integer scoresId, @Param("userId") Long userId);
}
